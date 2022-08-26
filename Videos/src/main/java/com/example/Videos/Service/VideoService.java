package com.example.Videos.Service;


import com.example.Videos.Entity.Video;
import com.example.Videos.Repository.VideoRepo;
import com.example.Videos.WrapperObjects.FeedbackWO;
import com.example.Videos.WrapperObjects.FriendsWO;
import com.example.Videos.WrapperObjects.VideoWrapperObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public VideoRepo videoRepo;

    @Value("${dockerizedHost}")
    private String host;



    public Video getVideoByVideoId(Long accountId, Long videoId ){

        Video video =  videoRepo.getVideosById(videoId);

        return video;
    }


    public List<Video> getVideosByOwnerId(Long accountId,Long ownerId,String ipAddress){

        List<Video>  videos = videoRepo.getVideosByOwnerId(ownerId);
        if(videos == null) return  null;
        if(accountId == ownerId) return videos;

        FriendsWO  friend =  restTemplate.getForObject("http://" + host + ":8500/account/" + accountId + "/friends/" + ownerId, FriendsWO.class);

        if(friend == null) return null;

        return videos;


    }


    public void feedback(FeedbackWO feedback) {

        long likes = feedback.getLikes();
        long dislikes = feedback.getDislikes();
        Video video = videoRepo.getById(feedback.getVideoId());

        video.setLikes(video.getLikes() + likes  );
        video.setDislikes(  video.getDislikes() + dislikes );

        videoRepo.save(video);

        return;
    }


    public List<Video>  getMySubscriptionVideos(Long accountId){

        List<FriendsWO>  friendList =  restTemplate.getForObject("http://" + host + ":8500/account/" + accountId + "/friends", List.class);

        ObjectMapper mapper = new ObjectMapper(); // or inject it as a dependency
        List<FriendsWO> myFriends = mapper.convertValue(friendList  , new TypeReference<List<FriendsWO>>() { });

        List<Video> list = new ArrayList<>();

        List<List<Video>> mylist = new ArrayList<>();

        mylist.add(videoRepo.getVideosByOwnerId(accountId));

        for(int x = 0 ; x < myFriends.size(); x++){

            Long id = myFriends.get(x).getFriendId();

                List<Video>  friendVideos = videoRepo.getVideosByOwnerId(id);
                mylist.add(friendVideos);
        }

        mylist.forEach(list::addAll);

        return list;
    }




    public List<Video> searchResults(String string){

        List<Video>  myVideos = videoRepo.getVideosByTitle(string);

        if(myVideos == null) return null;

        return myVideos;
    }


    public boolean saveVideo( Video video ){

        videoRepo.save(video);

        return true;
    }

    public boolean uploadVideo( MultipartFile file, String comments, String tags, long accountId, String owner, String title  ){

        String filePath = "/Videos/" + file.getOriginalFilename().replaceAll("\\s+","") ;

           try {

               Files.copy(file.getInputStream(), Paths.get(filePath));

        } catch (IOException e) {
            e.printStackTrace();
           // throw new RuntimeException("FAIL!");
               return false;
        }

        Video newVideo = new Video();
        newVideo.setBody(comments);
        newVideo.setTags(tags);
        newVideo.setDislikes(0);
        newVideo.setLikes(0);
        newVideo.setOwnerId(accountId);
        newVideo.setUrl("http://localhost:8080/" + file.getOriginalFilename().replaceAll("\\s+","") + ".mpd");
        newVideo.setTitle(title);
        newVideo.setOwnerName(owner);
        videoRepo.save(newVideo);



        return true;
    }








    public boolean updateVideo(Long accountId, Long videoId, VideoWrapperObject newVideo, String ipAddress){

        Video oldVideo =  videoRepo.getById(videoId);

        if(oldVideo.getOwnerId() != accountId) return false;

        String body = newVideo.getBody();

        oldVideo.setBody(body);

        videoRepo.save(oldVideo);

        return true;
    }


    public boolean deleteVideo(Long accountId, Long id,String ipAddress){
        videoRepo.deleteById(id);
        return true;

    }


    public void deleteAllVideosForOwnerId(Long accountId, Long ownerId,String ipAddress){
        videoRepo.deleteVideosByOwnerId(ownerId);

    }




    public boolean isThisFriendShipValid(long accountId, long friendId ){

        FriendsWO  friend =  restTemplate.getForObject("http://" + host + ":8500/account/" + accountId + "/friends/" + friendId, FriendsWO.class);

        if(friend == null) return false;

        return true;
    }





}
