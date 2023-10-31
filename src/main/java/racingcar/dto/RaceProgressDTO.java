package racingcar.dto;

import java.util.Collections;
import java.util.List;

public record RaceProgressDTO(List<String> nameAndDistanceMessages) {

    public RaceProgressDTO {
        nameAndDistanceMessages = Collections.unmodifiableList(nameAndDistanceMessages);
    }
}
