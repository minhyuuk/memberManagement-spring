package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L; // 키 값을 생성해주는 애, 실무에서는 어텀 롱? 이라는 걸 사용하라고 한다.


    @Override
    public Member save(Member member) {
        member.setId(++sequence);   // id는 시스템이 지정
        store.put(member.getId(),member); // store에 저장
        return member; // 결과 반환
    }

    @Override
    public Optional<Member> findByID(Long id) {
        // return store.get(id); 값이 Null 일 수도 있다. 사용 (X)
        return Optional.ofNullable(store.get(id)); // optional nullable 이름 보면 생각나듯
                                                   // null을 감싸주는 옵션이라고 기억하면 된다
    }

    // 루프를 돌다가 하나가 찾아진다면 그냥 바로 보내버리는 형식. 람다 사용
    // 끝까지 없다면 null을 그냥 반환해보림~
    @Override
    public Optional<Member> findByName(String name) {
        return   store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // findAny의 결과가 Optional로 반환됨
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        // values == member, 쫙 반환해줍니당
    }
    // 데이터 초기화 시켜주는 메서드
    public void clearStore() {
        store.clear();
    }
}
