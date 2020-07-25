package me.junsu.demospringdata;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

//domainClass : 이 Repository가 인터페이스하는 엔티티 테이블, idClass : 이 domainClass를 식별할 때 사용하는 클래스의 타입
//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
@Repository
public interface CommentRepository extends MyRepository<Comment, Long>{
}
