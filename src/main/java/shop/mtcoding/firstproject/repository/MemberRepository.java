package shop.mtcoding.firstproject.repository;

import org.springframework.data.repository.CrudRepository;
import shop.mtcoding.firstproject.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
