package com.example.demo; 

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.*;
	import org.springframework.web.bind.annotation.*;
	import org.springframework.web.multipart.MultipartFile;

	@RestController
	@RequestMapping("/video")
	public class VideoController {

	    @Autowired
	    private VideoService videoService;
	    
	    @PostMapping("/add")
	    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file) {
	        String fileName = videoService.saveVideo(file);
	        return ResponseEntity.ok("Uploaded: " + fileName);
	        
	    }

	    @PostMapping("/upload")
	    public ResponseEntity<String> uploadVideo1(@RequestParam("file") MultipartFile file) {
	        String fileName = videoService.saveVideo(file);
	        return ResponseEntity.ok("Video uploaded: " + fileName);
	    }

	    @GetMapping("/play/{fileName}")
	    public ResponseEntity<byte[]> playVideo(@PathVariable String fileName) {
	        Video video = videoService.getVideoByName(fileName);

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.parseMediaType(video.getType()));
	        headers.setContentLength(video.getData().length);

	        return new ResponseEntity<>(video.getData(), headers, HttpStatus.OK);
	    }
	}

