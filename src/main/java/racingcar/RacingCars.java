package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(String[] carsName) {
        this.racingCars = Arrays.stream(carsName).map(Car::new).collect(Collectors.toList());
    }

    public void move() {
        for (Car car : racingCars) {
            car.move(RandomUtil.getRandomNumber());
        }
    }

    public String getTotalExecuteResult() {
        StringBuilder totalExecuteResult = new StringBuilder();
        for (Car car: racingCars) {
            totalExecuteResult.append(car.getExecuteResult()).append("\n");
        }

        return totalExecuteResult.toString();
    }
}
