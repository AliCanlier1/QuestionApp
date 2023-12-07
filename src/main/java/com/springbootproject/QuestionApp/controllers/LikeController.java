package com.springbootproject.QuestionApp.controllers;

import com.springbootproject.QuestionApp.entities.Like;
import com.springbootproject.QuestionApp.requests.LikeCreateRequest;
import com.springbootproject.QuestionApp.services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("likes")
public class LikeController {

    private LikeService likeService;

    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }

    @GetMapping
    public List<Like> getLikes(@RequestParam Optional<Integer> postID, @RequestParam Optional<Integer> userID){
        return likeService.getLikes(postID, userID);
    }
    @GetMapping("/{likeId}")
    public Like getLike(@PathVariable("likeId") int likeId){
        return likeService.getLike(likeId);
    }

    @PostMapping
    public Like createLike(@RequestBody LikeCreateRequest request){
        return likeService.createLike(request);
    }

    @DeleteMapping("/{likeId}")
    public String deleteLike(@PathVariable("likeId") int likeId){
        return likeService.deleteLike(likeId);
    }
























}
