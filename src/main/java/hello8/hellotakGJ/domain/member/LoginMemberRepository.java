package hello8.hellotakGJ.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class LoginMemberRepository {

    private static Map<Long, LoginMember> store = new HashMap<>();
    private static long sequence = 0L;

    public LoginMember save(LoginMember member) {
        member.setId(++sequence);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;

    }

    public LoginMember findById(Long id) {
        return store.get(id);
    }

    public Optional<LoginMember> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();

    }

    public List<LoginMember> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStor(){
        store.clear();
    }
}
