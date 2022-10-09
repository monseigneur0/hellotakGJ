package hello8.hellotakGJ.practboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PboardService {

    private final PboardRepository pboardRepository;

    @Transactional
    public Long createcontent(Pboard pboard) {

        pboardRepository.save(pboard);
        return pboard.getId();
    }

    public List<Pboard> findBoards() {
        return pboardRepository.findAll();
    }
}
