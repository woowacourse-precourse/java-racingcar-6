package racingcar.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

public record CarsDto(List<CarDto> carDtoList) {
    public String getWinners() {
        return carDtoList.stream()
                .filter(car -> car.position() == sort().get(0).position())
                .map(CarDto::carName)
                .collect(Collectors.joining(", "));
    }

    private List<CarDto> sort() {
        return carDtoList.stream()
                .sorted((c1, c2) -> c2.position() - c1.position())
                .toList();
    }
}
