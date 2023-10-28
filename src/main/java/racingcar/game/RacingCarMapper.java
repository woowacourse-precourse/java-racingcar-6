package racingcar.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingCarResponse;

public class RacingCarMapper {
    private RacingCarMapper() {
    }

    public static List<RacingCarResponse> toDtoList(List<RacingCar> racingCars) {
        return racingCars.stream()
                .map(RacingCarMapper::toDto)
                .collect(Collectors.toList());
    }

    public static RacingCarResponse toDto(RacingCar racingCar) {
        return new RacingCarResponse(racingCar.getName(), racingCar.getPosition());
    }
}
