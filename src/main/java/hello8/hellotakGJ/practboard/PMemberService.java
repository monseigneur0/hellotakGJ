package hello8.hellotakGJ.practboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PMemberService {

    private final PMemberRepository pMemberRepository;

    @Transactional
    public Long createMember(PMember pMember) {

        pMemberRepository.save(pMember);
        return pMember.getId();
    }

    public List<PMember> allMembers() {
        return pMemberRepository.findAll();
    }
}
