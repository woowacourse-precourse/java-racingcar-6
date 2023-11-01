package racingcar.dto;

import java.util.List;
import racingcar.domain.Racing;

public record RacingResultDto(List<CarDto> cars) {

    public static RacingResultDto from(Racing racing) {
        List<CarDto> cars = racing.getCars().stream()
                .map(CarDto::from).toList();
        return new RacingResultDto(cars);
    }
}
