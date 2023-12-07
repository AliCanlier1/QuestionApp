package com.springbootproject.QuestionApp.repos;

import com.springbootproject.QuestionApp.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {

    @Query(value="SELECT * FROM t_like where post_id= :postId and user_id = :userId", nativeQuery = true)
    List<Like> getLikesByPostIdandUserId(@Param("postId")int postID, @Param("userId")int userID);

    @Query(value="SELECT * FROM t_like where post_id= :postId", nativeQuery = true)
    List<Like> getLikesByPostId(@Param("postId") int postID);

    @Query(value="SELECT * FROM t_like where user_id = :userId", nativeQuery = true)
    List<Like> getLikesByUserId(@Param("userId") int userID);
}
