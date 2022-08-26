package com.example.Videos.Controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.Videos.Entity.Video;
import com.example.Videos.Repository.VideoRepo;
import com.example.Videos.WrapperObjects.*;
import com.example.Videos.Service.VideoService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {


    @Autowired
    public VideoService videoService;



    @GetMapping("/{accountId}/{videoId}")
    public ResponseEntity<Video> getAVid(@PathVariable(value="videoId") long videoId,
                                         @PathVariable(value="accountId") long accountId
                                         ){


        Video video = videoService.getVideoByVideoId(accountId,videoId);

        if(video == null){
            return new ResponseEntity("404 Not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(video, HttpStatus.OK);
    }



    @GetMapping("/{accountId}/feed")
    public ResponseEntity<VideoList > getVideoFeed(@PathVariable(value="accountId") long accountId){


        List<Video>  myList =  videoService.getMySubscriptionVideos(accountId);

        VideoList videoList = new VideoList(myList);

        if(myList == null){
            return new ResponseEntity("404 Not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(videoList, HttpStatus.OK);
    }


    @PostMapping("/{accountId}/upload")
    public ResponseEntity<String>  upload(@PathVariable(value="accountId") long accountId,
                                          @RequestPart("body")  String comment,
                                          @RequestPart("tags")  String tags,
                                          @RequestPart("title")  String title,
                                          @RequestPart("owner")  String owner,
                                          @RequestPart("file")  MultipartFile file){

        boolean valid = videoService.uploadVideo(file,comment,tags,accountId,  owner, title);

        if(valid == false){
            return new ResponseEntity("403 Forbidden", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PostMapping("/{accountId}/save")
    public ResponseEntity<String>  save(@PathVariable(value="accountId") long accountId,
                                        @RequestBody  Video video){

        boolean valid = videoService.saveVideo(video);

        if(valid == false){
            return new ResponseEntity("403 Forbidden", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PostMapping("/feedback")
    public ResponseEntity feedback(@RequestBody FeedbackWO feedback, HttpServletRequest request){

        videoService.feedback(feedback);

        return new ResponseEntity( HttpStatus.OK);
    }


    @DeleteMapping("/{accountId}/{videoId}")
    public ResponseEntity<String> delete(@PathVariable(value="accountId") long accountId,
                                         @PathVariable(value="videoId") long videoId ,
                                         HttpServletRequest request){

        String ipAddress = request.getRemoteAddr();
        boolean valid = videoService.deleteVideo(accountId, videoId,ipAddress);

        if(valid == false){
            return new ResponseEntity("403 Forbidden", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }


    @PutMapping("/{accountId}/{videoId}")
    public ResponseEntity<String> editVideo(@PathVariable(value="videoId") long accountId ,
                                            @PathVariable(value="videoId") long videoId,
                                            @RequestBody VideoWrapperObject video ,
                                            HttpServletRequest request){

        String ipAddress = request.getRemoteAddr();
        boolean success = videoService.updateVideo(accountId,videoId,video ,ipAddress);

        if(success == false){
            return new ResponseEntity("403 Forbidden", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<VideoList> search(@RequestParam("query") String string){

        List<Video> results = videoService.searchResults(string);

        if(results == null) return new ResponseEntity( HttpStatus.NO_CONTENT);

        VideoList videoList = new VideoList(results);

        return new ResponseEntity<>(videoList, HttpStatus.OK);
    }


}
