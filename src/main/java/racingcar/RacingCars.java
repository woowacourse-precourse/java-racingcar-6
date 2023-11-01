package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(String[] carsName) {
        validateCarsSize(carsName);
        validateDuplicateCarName(carsName);
        this.racingCars = Arrays.stream(carsName)
                .map(carName -> new Car(carName, GameConfig.INIT_NUMBER.getValue()))
                .collect(Collectors.toList());
    }

    public void move() {
        for (Car car : racingCars) {
            car.move(RandomUtil.getRandomNumber());
        }
    }

    public String getTotalExecuteResult() {
        StringBuilder totalExecuteResult = new StringBuilder();
        for (Car car : racingCars) {
            totalExecuteResult.append(car.getExecuteResult()).append("\n");
        }

        return totalExecuteResult.toString();
    }

    public List<String> getWinner() {
        Collections.sort(racingCars);

        return calculateWinner();
    }

    private void validateCarsSize(String[] carsName) {
        if (carsName.length < GameConfig.MIN_CAR_COUNT.getValue() || carsName.length > GameConfig.MAX_CAR_COUNT.getValue()) {
            throw new IllegalArgumentException("입력한 자동차 수가 초과되었습니다.");
        }
    }

    private void validateDuplicateCarName(String[] carsName) {
        if (Arrays.stream(carsName).distinct().count() != carsName.length) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
    }

    private List<String> calculateWinner() {
        List<String> winners = new ArrayList<>();
        winners.add(racingCars.get(0).getName());

        for (int i = 1; i < racingCars.size(); i++) {
            if (!racingCars.get(i).isSamePosition(racingCars.get(0))) {
                return winners;
            }
            winners.add(racingCars.get(i).getName());
        }

        return winners;
    }
}
