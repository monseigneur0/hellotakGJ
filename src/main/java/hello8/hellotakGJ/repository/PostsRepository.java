package hello8.hellotakGJ.repository;

import hello8.hellotakGJ.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
