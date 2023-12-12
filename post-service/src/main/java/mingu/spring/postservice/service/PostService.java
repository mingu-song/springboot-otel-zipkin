package mingu.spring.postservice.service;

import io.micrometer.tracing.annotation.NewSpan;
import lombok.RequiredArgsConstructor;
import mingu.spring.postservice.domain.Post;
import mingu.spring.postservice.feign.CommentFeignClient;
import mingu.spring.postservice.model.CommentResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class PostService {
    private final CommentFeignClient commentFeignClient;

    @NewSpan(value = "post-service-findAllPost-span")
    public List<Post> findAllPost() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1_000);
        return List.of(new Post(1, "What is the Prometheus", "Nice tool", null));
    }

    @NewSpan(value = "post-service-getPostWithComments-span")
    public Post getPostWithComments(int postId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        List<CommentResponseModel> comments = commentFeignClient.findCommentsByPostId(postId);
        return new Post(1, "What is the Zipkin?", "Nice tool", comments);
    }
}
