package hello8.hellotakGJ.practboard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PboardRepository extends JpaRepository<Pboard, Long> {

    List<Pboard> findByTitle(String title);

}
