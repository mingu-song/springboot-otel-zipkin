package mingu.spring.commentservice.controller;

import mingu.spring.commentservice.model.Comment;
import mingu.spring.commentservice.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("")
    public List<Comment> findCommentsByPostId(@RequestParam int postId) throws InterruptedException {
        return commentService.findCommentsByPostId(postId);
    }
}
