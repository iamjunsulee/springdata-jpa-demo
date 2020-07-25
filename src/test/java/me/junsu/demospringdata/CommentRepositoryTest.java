package me.junsu.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.COMM_FAILURE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() {
        this.createComment(100, "spring data jpa");
        this.createComment(55, "Hello Spring");

        //List<Comment> comments = commentRepository.findAll();
        //assertEquals(comments.size(), 1);
        //assertEquals(commentRepository.count(), 1);

        //Optional<Comment> byId = commentRepository.findById(100L);
        //assertEquals(byId, Optional.empty());
        //Comment comment1 = byId.orElseThrow(IllegalArgumentException::new);

        //commentRepository.save(null);
        List<Comment> commentList = commentRepository.findByCommentContainsIgnoreCase("hello");
        assertEquals(commentList.size(), 1);

        List<Comment> spring = commentRepository.findByCommentContainsOrderByLikeCountAsc("spring");
        assertEquals(spring.get(0).getComment(), "spring data jpa");

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "likeCount"));
        //Page<Comment> pages = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest);
        //assertEquals(pages.getTotalElements(), 2);

        //stream을 다 쓴 다음에 close해야하므로 try-with-resource 사용할 것.
        try(Stream<Comment> commentStream = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest)){
            Comment comment1 = commentStream.findFirst().get();
            assertEquals(Optional.ofNullable(comment1.getLikeCount()), Optional.ofNullable(100));
        }
    }

    private void createComment(int likeCount, String word) {
        Comment comment = new Comment();
        comment.setLikeCount(likeCount);
        comment.setComment(word);
        commentRepository.save(comment);
    }
}