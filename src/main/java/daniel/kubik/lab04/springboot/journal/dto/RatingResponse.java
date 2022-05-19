package daniel.kubik.lab04.springboot.journal.dto;

import lombok.Data;

import java.util.List;

@Data
public class RatingResponse {
    List<RatingData> ratingData;
}
