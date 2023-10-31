package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class RoundResultDto {

    private final List<CarStatusDto> roundResult;

    private RoundResultDto(List<CarStatusDto> roundResult) {
        this.roundResult = roundResult;
    }

    public static RoundResultDto createFrom(List<Car> cars) {
        List<CarStatusDto> carStatusDtos = cars.stream()
                .map(CarStatusDto::createFrom)
                .collect(Collectors.toList());
        return new RoundResultDto(carStatusDtos);
    }

    public List<CarStatusDto> getRoundResult() {
        return roundResult;
    }


}
