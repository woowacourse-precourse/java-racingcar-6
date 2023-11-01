package racingcar.Dto;

import java.util.List;
import racingcar.domain.Racing;

public record CurrentRacingStatusDto(
        List<CarDto> cars
) {
    public CurrentRacingStatusDto(Racing racing) {
        this(racing.getParticipant().stream()
                .map(CarDto::new)
                .toList()
        );
    }
}
