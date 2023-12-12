package mingu.spring.postservice.service;

import io.micrometer.tracing.annotation.NewSpan;
import mingu.spring.postservice.domain.Post;
import mingu.spring.postservice.feign.CommentFeignClient;
import mingu.spring.postservice.model.CommentResponseModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostService {
    private final RestTemplate restTemplate;
    private final CommentFeignClient commentFeignClient;

    public PostService(RestTemplate restTemplate, CommentFeignClient commentFeignClient) {
        this.restTemplate = restTemplate;
        this.commentFeignClient = commentFeignClient;
    }

    @NewSpan(value = "post-service-getPostWithComments-span")
    public Post getPostWithComments(int id) throws InterruptedException {
        Thread.sleep(500);
        List<CommentResponseModel> comments = commentFeignClient.findCommentsByPostId(id);
        return new Post(1, "What is the Zipkin?", "Nice tool", comments);
    }
}
