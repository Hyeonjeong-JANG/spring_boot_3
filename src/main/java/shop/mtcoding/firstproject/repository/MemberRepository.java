package shop.mtcoding.firstproject.repository;

import org.springframework.data.repository.CrudRepository;
import shop.mtcoding.firstproject.entity.Member;

import java.util.ArrayList;

public interface MemberRepository extends CrudRepository<Member, Long> {
    @Override
    ArrayList<Member> findAll();
}
