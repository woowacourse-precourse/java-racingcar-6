package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(String[] carsName) {
        validateCarsSize(carsName);
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

    private void validateCarsSize(String[] carsName) {
        if (carsName.length < GameConfig.MIN_CAR_COUNT.getValue() || carsName.length > GameConfig.MAX_CAR_COUNT.getValue()) {
            throw new IllegalArgumentException("입력한 자동차 수가 초과되었습니다.");
        }
    }

}
