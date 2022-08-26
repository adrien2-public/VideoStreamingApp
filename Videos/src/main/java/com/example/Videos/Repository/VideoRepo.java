package com.example.Videos.Repository;

import com.example.Videos.Entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepo extends JpaRepository<Video,Long> {


    @Query("SELECT v FROM Video v WHERE v.ownerId = :ownerId")
    public List<Video> getVideosByOwnerId(@Param("ownerId") Long ownerId);

    @Query("SELECT v FROM Video v WHERE v.id = :id")
    public Video getVideosById(@Param("id") Long id);

    @Query("SELECT v FROM Video v WHERE v.ownerId = :ownerId OR v.ownerId = :friendId")
    public List<Video> getVideosByFeed(@Param("ownerId") Long ownerId,@Param("friendId") Long friendId );



    @Query("SELECT v FROM Video v WHERE v.title LIKE CONCAT('%' , :title, '%')" )
    public List<Video> getVideosByTitle(@Param("title") String title);


    @Query("DELETE  FROM Video v WHERE v.ownerId = :ownerId")
    public void deleteVideosByOwnerId(@Param("ownerId") Long ownerId);



}
