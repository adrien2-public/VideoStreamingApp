#!/bin/bash


while true
do

if [ "$(ls -A  Videos/)" ]; then

for f in Videos/*.mp4
do
filename=$(basename  "$f")
filename2=$(basename  "$f" .mp4)
high="${filename2}_720.mp4"
med="${filename2}_540.mp4"
low="${filename2}_360.mp4"
audio="${filename2}_audio.mp4"
final="${filename2}.mpd"

        ffmpeg -y -i  $f  -s 1280x720 -c:a copy -c:v libx264 -x264opts "keyint=24:min-keyint=24:no-scenecut" -preset ultrafast -crf 24 -b:v 1500k -maxrate 1500k  -bufsize 1000k $high

        wait
        ffmpeg -y -i  $f -s 960x540 -c:a copy -c:v libx264 -x264opts "keyint=24:min-keyint=24:no-scenecut" -preset ultrafast -crf 24  -b:v 800k -maxrate 800k  -bufsize 500k  $med

        wait
        ffmpeg -y -i  $f -s 640x360 -c:a copy -c:v libx264 -x264opts "keyint=24:min-keyint=24:no-scenecut" -preset ultrafast -crf 24 -b:v 400k -maxrate 400k  -bufsize 400k  $low

        wait

        ./packager-linux-x64 input=$high,stream=audio,output=/usr/local/apache2/htdocs/$audio input=$high,stream=video,output=/usr/local/apache2/htdocs/$high input=$med,stream=video,output=/usr/local/apache2/htdocs/$med input=$low,stream=video,output=/usr/local/apache2/htdocs/$low   --profile on-demand --mpd_output /usr/local/apache2/htdocs/$final   --base_urls http://localhost:8080 --min_buffer_time 6  --segment_duration 6
  
 wait
    # if file, delete it
   [ -f "$f" ] && rm "$f"
	rm "$high"
	rm "$med"
	rm "$low"

echo "Removed now"
done

fi

done

