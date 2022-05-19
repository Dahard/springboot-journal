package daniel.kubik.lab04.springboot.journal.mappers;

import daniel.kubik.lab04.springboot.journal.dto.RatingData;
import daniel.kubik.lab04.springboot.journal.model.Rating;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RatingMapper {
    List<RatingData> map(List<Rating> ratings);
}
