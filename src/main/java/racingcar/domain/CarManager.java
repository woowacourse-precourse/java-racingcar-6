package racingcar.domain;


import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;

public class CarManager {
    private final RandomNumberGenerator randomNumberGenerator;

    public CarManager(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<Car> initializeCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
    }

    public void moveCarForward(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.generate();
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    public List<Car> findWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);

        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }
}
