package com.hopper.restapi.repository;

import com.hopper.restapi.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    /* Arguments implementation types:
    1)
    @Query("Select p from Post p where :title")
    List<Post> findAllByTitle(@Param("title") String title);
    2)
    @Query("Select p from Post p where title=?1")
    List<Post> findAllByTitle( String title);
    3)
    title as compiler argument- in build.gradle task compileJava { options.compilerArgs << '-parameters' }
        and in Intellij in Java Compiler add in additional command lines parameters-parameters
    4)
    Only findAllByTitle by Spring data name convention based on documentation
    List<Post> findAllByTitle...
    List<Post> findByDateAndTitle...
    List<Post> findByTitleIn...string...
    */

    @Query("Select p from Post p where title=?1")
    List<Post> findAllByTitle(@Param("title") String title);

//    @Query("Select p from Post p left join fetch p.comments ")
    @Query("Select p from Post p")
    List<Post> findAllPosts(Pageable page);
}
