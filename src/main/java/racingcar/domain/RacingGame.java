package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RandomGenerator;

public class RacingGame {

    private List<Car> cars;
    private RandomGenerator randomGenerator;

    public RacingGame(List<String> carNames, RandomGenerator randomGenerator) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.randomGenerator = randomGenerator;
    }

    public void race() {
        for (Car car : cars) {
            int randomValue = randomGenerator.pick();
            car.move(randomValue);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        int farthestDistance = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == farthestDistance)
                .collect(Collectors.toList());
    }

    public void printWinners() {
        List<Car> winners = findWinners();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }


}
