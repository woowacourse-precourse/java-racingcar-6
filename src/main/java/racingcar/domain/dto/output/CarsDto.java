package racingcar.domain.dto.output;

import java.util.List;
import java.util.function.Predicate;

public record CarsDto(List<CarDto> carDtoList) {

    private static Predicate<CarDto> ifPositionIsSameWithMaxPosition(int max) {
        return carDto -> carDto.position() == max;
    }

    public WinnersDto getWinners() {
        int max = carDtoList.stream()
                .mapToInt(CarDto::position)
                .max()
                .getAsInt();
        return new WinnersDto(carDtoList.stream()
                .filter(ifPositionIsSameWithMaxPosition(max))
                .map(CarDto::name)
                .toList());
    }
}
