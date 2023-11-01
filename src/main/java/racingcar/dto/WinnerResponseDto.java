package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public record WinnerResponseDto(List<String> winnerNames) {

    public static WinnerResponseDto createWinnerResponseDto(List<Car> findCars) {
        return new WinnerResponseDto(findCars.stream()
                .map(Car::getName)
                .collect(Collectors.toList()));
    }
}
