package com.cap.college_admission_portal.feedback;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class FeedbackService {
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

    public ResponseEntity<String> saveFeedback(Feedback request) {
        ResponseEntity<String> response = restTemplate().postForEntity(
            "http://localhost:8081/postFeedback",
            request,
            String.class);
        return response;
    }

    public List<Feedback> getFeedbacks() {
        ResponseEntity<List<Feedback>> responseEntity = restTemplate().exchange(
            "http://localhost:8081/getAll",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Feedback>>() {});
            return responseEntity.getBody();
    }
    
}
