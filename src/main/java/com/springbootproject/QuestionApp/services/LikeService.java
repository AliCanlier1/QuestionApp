package com.springbootproject.QuestionApp.services;

import com.springbootproject.QuestionApp.entities.Like;
import com.springbootproject.QuestionApp.entities.Post;
import com.springbootproject.QuestionApp.entities.User;
import com.springbootproject.QuestionApp.repos.LikeRepository;
import com.springbootproject.QuestionApp.requests.LikeCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    private LikeRepository likeRepository;
    private PostService postService;
    private UserService userService;

    public LikeService(LikeRepository likeRepository, PostService postService, UserService userService) {
        this.likeRepository = likeRepository;
        this.postService = postService;
        this.userService = userService;
    }

    public List<Like> getLikes(Optional<Integer> postID, Optional<Integer> userID) {
        if(postID.isPresent() && userID.isPresent()){
            return likeRepository.getLikesByPostIdandUserId(postID.get(), userID.get());
        }
        else if(postID.isPresent()){
            return likeRepository.getLikesByPostId(postID.get());
        }
        else if(userID.isPresent()){
            return likeRepository.getLikesByUserId(userID.get());
        }
        else{
            return likeRepository.findAll();
        }
    }

    public Like createLike(LikeCreateRequest request) {
        Post post = postService.getPostById(request.getPostId());
        User user = userService.getUserById(request.getUserId());
        if(post!=null&&user!=null){
            Like like = new Like(post, user);
            likeRepository.save(like);
            return like;
        }
        return null;
    }

    public Like getLike(int likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }

    public String deleteLike(int likeId) {
        likeRepository.deleteById(likeId);
        return "The like which id is "+ likeId+ " have been deleted successfully.";
    }
}
