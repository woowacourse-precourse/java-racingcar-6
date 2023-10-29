package racingcar.dto.response;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.CarGroup;

public class RaceStageDto {
    private final List<CarProgressDto> carProgresses;

    private RaceStageDto(List<CarProgressDto> carProgresses) {
        this.carProgresses = carProgresses;
    }

    public static RaceStageDto from(CarGroup carGroup) {
        List<Car> cars = carGroup.getCars();
        List<CarProgressDto> carProgressDtoList = getCarProgressDtoList(cars);
        return new RaceStageDto(carProgressDtoList);
    }

    private static List<CarProgressDto> getCarProgressDtoList(List<Car> cars) {
        return cars.stream()
                .map(CarProgressDto::from)
                .collect(Collectors.toList());
    }

    public List<CarProgressDto> getCarProgresses() {
        return carProgresses;
    }
}
