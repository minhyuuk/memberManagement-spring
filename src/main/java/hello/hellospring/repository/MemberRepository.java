package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

// 회원 객체를 저장할 저장소 !
public interface MemberRepository {

    Member save(Member member); // 회원 저장, 반환

    Optional<Member> findByID(Long id); // kotlin의 findViewById 같은 개념이라 보면 됨

    Optional<Member> findByName(String name); // 이건 name

    List<Member> findAll(); // 지금까지 저장된 모든 회원 리스트 반환
}
