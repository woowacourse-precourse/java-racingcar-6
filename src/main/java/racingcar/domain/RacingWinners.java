package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.factory.DTOFactory;
import racingcar.dto.output.WinnerDTO;

public class RacingWinners {
    private final List<Car> cars;

    public RacingWinners(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public WinnerDTO getFinalResult() {
        int winnerDistance = findWinnerDistance();
        List<String> winnerNames = findWinnerNames(winnerDistance);
        return DTOFactory.createWinnerDTO(winnerNames);
    }

    // 승자의 거리를 찾는 메서드
    private int findWinnerDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    // 승자의 이름을 찾는 메서드
    private List<String> findWinnerNames(int winnerDistance) {
        return cars.stream()
                .filter(car -> car.isWinner(winnerDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
