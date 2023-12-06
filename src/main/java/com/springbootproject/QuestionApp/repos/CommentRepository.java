package com.springbootproject.QuestionApp.repos;

import com.springbootproject.QuestionApp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT * FROM comment WHERE user_id = :userId and post_id = :postId", nativeQuery = true)
    List<Comment> getByPostandUserID(@Param("postId")int postID, @Param("userId")int userID);

    @Query(value = "SELECT * FROM comment WHERE post_id = :postId", nativeQuery = true)
    List<Comment> getByPostID(@Param("postId") int postID);

    @Query(value = "SELECT * from comment WHERE user_id = :userId", nativeQuery = true)
    List<Comment> getByUserID(@Param("userId") int userID);
}
