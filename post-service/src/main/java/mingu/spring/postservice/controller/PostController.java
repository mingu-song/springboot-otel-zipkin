package mingu.spring.postservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mingu.spring.postservice.domain.Post;
import mingu.spring.postservice.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("")
    public List<Post> findAllPost() throws InterruptedException {
        log.info("findAllPost");
        return postService.findAllPost();
    }

    @GetMapping(path = "/{postId}")
    public Post getPostWithComments(@PathVariable int postId) throws InterruptedException {
        log.info("getPostWithComments : {}", postId);
        return postService.getPostWithComments(postId);
    }
}
