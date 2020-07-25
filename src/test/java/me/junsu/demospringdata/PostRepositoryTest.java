package me.junsu.demospringdata;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
    public void crudRepository(){
        //given
        Post post = new Post();
        post.setTitle("아쌀라이쿰");
        assertEquals(post.getId(), null);

        //when
        Post newPost = postRepository.save(post);
        List<Post> posts = postRepository.findAll();

        //then
        assertNotEquals(newPost.getId(), null);
        assertTrue(posts.contains(newPost));

        //when
        Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));
        //then
        assertEquals(page.getTotalElements(),1);
        assertEquals(page.getNumber(), 0);
        assertEquals(page.getSize(), 10);
        assertEquals(page.getNumberOfElements(), 1);

        //when
        page = postRepository.findByTitleContains("아쌀라이쿰", PageRequest.of(0, 10));
        //then
        assertEquals(page.getTotalElements(),1);
        assertEquals(page.getNumber(), 0);
        assertEquals(page.getSize(), 10);
        assertEquals(page.getNumberOfElements(), 1);

        //when
        long count = postRepository.countByTitle("아쌀라이쿰");
        assertEquals(count, 1);
    }
}