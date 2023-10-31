package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingRoundResult;

public record RacingRoundResultDto(List<CarDto> carDtos) {

    public static RacingRoundResultDto from(RacingRoundResult racingRoundResult) {
        List<CarDto> carInfos = racingRoundResult.getCars().stream()
                .map(CarDto::from)
                .collect(Collectors.toUnmodifiableList());
        return new RacingRoundResultDto(carInfos);
    }
}
