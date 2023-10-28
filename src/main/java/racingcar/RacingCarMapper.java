package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingCarDto;

public class RacingCarMapper {
    private RacingCarMapper() {
    }

    public static List<RacingCarDto> toDtoList(List<RacingCar> racingCars) {
        return racingCars.stream()
                .map(RacingCarMapper::toDto)
                .collect(Collectors.toList());
    }

    public static RacingCarDto toDto(RacingCar racingCar) {
        return new RacingCarDto(racingCar.getName(), racingCar.getPosition());
    }
}
