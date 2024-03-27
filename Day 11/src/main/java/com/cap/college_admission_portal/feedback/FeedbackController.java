package com.cap.college_admission_portal.feedback;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.college_admission_portal.constant.Api;
import com.cap.college_admission_portal.dto.response.FeedbackResponse;

@RestController

public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

     @PostMapping("/postFeedback")
    public ResponseEntity<String> saveFeedback(@RequestBody Feedback request) {
        return feedbackService.saveFeedback(request);
    }



    @GetMapping("/getAll")
    public List<Feedback> getFeedbacks() {
        // List<Feedback> feedbackList = 
        // return !feedbackList.isEmpty() ? ResponseEntity.ok(feedbackList) : "";
        return feedbackService.getFeedbacks();
    }
    
}
