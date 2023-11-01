package racingcar.model;

import static racingcar.model.CarNameValidator.validateCarNames;
import static racingcar.utils.Constants.CAN_GO_NUMBER;
import static racingcar.utils.Constants.INIT_START_POSITION;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarNames(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<String> getWinner() {
        List<String> winners = cars.stream()
                .filter(car -> car.getDistance() == maxDistance())
                .map(Car::getName)
                .collect(Collectors.toList());

        return winners;
    }

    public int maxDistance() {
        int max = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(INIT_START_POSITION);

        return max;
    }

    public void playOneGame() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.makeNumber();
            if (randomNumber >= CAN_GO_NUMBER) {
                car.go();
            }
        }
    }
}
