package daniel.kubik.lab04.springboot.journal.repository;

import daniel.kubik.lab04.springboot.journal.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
