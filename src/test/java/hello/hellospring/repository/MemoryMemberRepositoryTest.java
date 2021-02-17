package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository =  new MemoryMemberRepository();

    // ★중요★
    // 공용 데이터는 깔~끔하게 지워줘야한다
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test // 테스트하기
    public void save() {
        Member member = new Member();
        member.setName("minhyuuk");

        repository.save(member);

        Member result = repository.findByID(member.getId()).get();
        assertThat(result).isEqualTo(member);

    }

    @Test
    public void findByName() {

        Member member1 = new Member();
        member1.setName("minhyuuk");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("minhyaak");
        repository.save(member2);

        Member result = repository.findByName("minhyuuk").get();

        assertThat(result).isEqualTo(member1); // member1과 값이 같은지 판단
                                               // 값이 다르다면 에러 표시가 뜬다.
    }

    @Test
    public void findAll() {
        // 이 코드에서는 맴버 두 명이 떠야한다
        Member member1 = new Member();
        member1.setName("minhyuuk");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("minhyuuk");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }

}
// 항상 테스트를 해주세용!! 테스트를 하면 안전하잖아요 ㅎㅎ

// 테스트의 순서는 랜덤이다. findAll에서 테스트가 진행되고
// findByName으로 넘어갔으므로 값을 초기화시킨 후 넘어가야한다.
