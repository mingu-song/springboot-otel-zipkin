package mingu.spring.commentservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mingu.spring.commentservice.model.Comment;
import mingu.spring.commentservice.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("")
    public List<Comment> findCommentsByPostId(@RequestParam int postId) throws InterruptedException {
        log.info("findCommentsByPostId : {}", postId);
        return commentService.findCommentsByPostId(postId);
    }
}
