package racingcar.domain.car.dto.output;

import java.util.List;

public record WinnersDto(
        List<WinnerDto> winners
) {
}
