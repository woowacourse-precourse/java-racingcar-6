package racingcar.model;

import java.util.List;
import racingcar.model.dto.CarDto;

public class Game {

    private final List<Car> cars;
    private final int totalRounds;
    private int completedRounds;

    public Game(List<Car> cars, int totalRounds) {
        this.cars = cars;
        this.totalRounds = totalRounds;
        this.completedRounds = 0;
    }

    public List<String> getWinnerNames() {
        int maxLocation = cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .toList();
    }

    public boolean hasRemainingRounds() {
        return completedRounds < totalRounds;
    }

    public void playOneRound() {
        cars.forEach(Car::moveIfPossible);
        completedRounds++;
    }

    public List<CarDto> getCars() {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getLocation()))
                .toList();
    }
}
