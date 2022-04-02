package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    // 강의에서는 static 키워드가 있었는데, Singleton 으로 MemberRepository 클래스를
    // 사용하기 때문에 굳이 필요는 없어서 해당 예제에서는 제외했다.

    private final Map<Long, Member> store = new HashMap<>();
    private Long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    private MemberRepository() {}

    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    // ArrayList 의 값을 조작하거나 바꿔도 store 에 영향을 주지 않기 위한 구조
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
