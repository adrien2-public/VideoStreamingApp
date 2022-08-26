package com.example.Videos.Repository;

import com.example.Videos.Entity.VideoAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsRepo extends JpaRepository<VideoAnalytics,Long> {

}
