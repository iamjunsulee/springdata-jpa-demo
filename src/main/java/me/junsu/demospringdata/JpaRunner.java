package me.junsu.demospringdata;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

//    @PersistenceContext
//    EntityManager entityManager;
    @Autowired
    PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Account account = new Account();
//        account.setUsername("junsu");
//        account.setPassword("hibernate");
//
//        Study study = new Study();
//        study.setName("springdatajpa");
////        study.setOwner(account);
//
//        account.addStudy(study);
////        account.getStudies().add(study);
////        study.setOwner(account);
//
////        entityManager.persist(account);
//        Session session = entityManager.unwrap(Session.class);
//        session.save(account);
//        session.save(study);
//
//        Account js = session.load(Account.class, account.getId());
//        js.setUsername("spring");   // dirty checking, 따로 update를 실행하지도 않았는데 update query를 실행
//        js.setUsername("spring2345");
//        js.setUsername("junsu");    //dirty checking과 write behind가 적용된 예, 원래 insert할 내용과 동일하므로 굳이 update query를 실행할 필요가 없는 경우
//        System.out.println("=====================");
//        System.out.println(js.getUsername());   //이 시점에는 저장도 하지 않은 상태

//        Post post = new Post();
//        post.setTitle("Spring Data JPA");
//
//        Comment comment = new Comment();
//        comment.setComment("빨리보자");
//        post.addComment(comment);
//
//        Comment comment2 = new Comment();
//        comment2.setComment("꼭보자");
//        post.addComment(comment2);

//        Session session = entityManager.unwrap(Session.class);
////        session.save(post);
//        Post p = session.load(Post.class, 1l);
//        System.out.println("====================");
//        System.out.println(p.getTitle());
//
//        p.getComments().forEach(c ->{
//            System.out.println("-------------------");
//            System.out.println(c.getComment());
//        });

        //타입 세이프하지 않음. 오타가 나올수도 있고..(JPQL)
//        TypedQuery<Post> query = entityManager.createQuery("select p from Post as p", Post.class);
//        List<Post> posts = query.getResultList();
//        posts.forEach(System.out::println); //toString()에 comments 포함시켰더니 comment 쿼리도 날려서 조회함.

        //직접 sql을 작성하지 않기 때문에 타입 세이프하긴 하다.
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Post> query = builder.createQuery(Post.class);
//        Root<Post> from = query.from(Post.class);
//        query.select(from);
//
//        List<Post> posts = entityManager.createQuery(query).getResultList();
//        posts.forEach(System.out::println);

        //postRepository.findAll().forEach(System.out::println);
        Post post = new Post();
        post.setTitle("leejunsu");

        Comment comment = new Comment();
        comment.setComment("gkgkgkgkgkgk");

        postRepository.save(post);
    }
}
