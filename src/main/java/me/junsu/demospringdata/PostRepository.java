package me.junsu.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByTitleContains(String title, Pageable pageable);

    long countByTitle(String title);
//    @PersistenceContext
//    EntityManager entityManager;
//
//    public Post add(Post post){
//        entityManager.persist(post);
//        return post;
//    }
//
//    public void delete(Post post){
//        entityManager.remove(post);
//    }
//
//    public List<Post> findAll(){
//        return entityManager.createQuery("select p from Post as p", Post.class).getResultList();
//    }
}
