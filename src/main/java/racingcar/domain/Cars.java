package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Cars {
    private List<Car> cars;
    private RandomGenerator randomGenerator;

    public Cars(List<String> carName, RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.cars = carName.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<EachMoveResultDto> moveCarsAndCollectResults() {
        return cars.stream()
                .peek(this::moveCarForward)
                .map(this::collectMoveResult)
                .collect(Collectors.toList());
    }

    private void moveCarForward(Car car) {
        car.moveFoward(randomGenerator.generate());
    }

    private EachMoveResultDto collectMoveResult(Car car) {
        String carName = car.getName();
        int position = car.getPosition();
        return new EachMoveResultDto(carName, position);
    }

    public List<GameWinnerDto> findWinnersDto() {
        return findWinners().stream()
                .map(car -> new GameWinnerDto(car.getName()))
                .collect(Collectors.toList());
    }

    private List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
