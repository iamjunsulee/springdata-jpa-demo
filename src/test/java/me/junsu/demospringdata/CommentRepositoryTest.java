package me.junsu.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.COMM_FAILURE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() {
        Comment comment = new Comment();
        comment.setComment("Hello World");
        commentRepository.save(comment);

        List<Comment> comments = commentRepository.findAll();
        assertEquals(comments.size(), 1);
        assertEquals(commentRepository.count(), 1);
    }
}