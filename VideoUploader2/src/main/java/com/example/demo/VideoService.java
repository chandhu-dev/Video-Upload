package com.example.demo;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.web.multipart.MultipartFile;

	import java.io.IOException;

	@Service
	public class VideoService {

	    @Autowired
	    private VideoRepository videoRepository;

	    public String saveVideo(MultipartFile file) {
	        try {
	            Video video = new Video();
	            video.setName(file.getOriginalFilename());
	            video.setType(file.getContentType());
	            video.setData(file.getBytes());
	            videoRepository.save(video);
	            return video.getName();
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to store video", e);
	        }
	    }

	    public Video getVideoByName(String name) {
	        return videoRepository.findByName(name)
	                .orElseThrow(() -> new RuntimeException("Video not found: " + name));
	    }
	}

