package mingu.spring.postservice.controller;

import mingu.spring.postservice.domain.Post;
import mingu.spring.postservice.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/{id}")
    public Post postWithComments(@PathVariable int id) throws InterruptedException {
        return postService.getPostWithComments(id);
    }
}
