package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.StringUtils;
import racingcar.utils.constant.Constant;
import racingcar.utils.validation.InputValidation;

public class Race {
    private Cars cars;
    private int moveCount;

    public Race(String carNames, String count) {
        this.cars = new Cars(carNames);
        this.moveCount = StringUtils.convertStringToInt(count);
        InputValidation.validateCountRange(moveCount);
    }

    public void moveCars() {
        cars.move();
    }

    public int getMoveCount() {
        return moveCount;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getMaxCount() {
        return cars.getCars().stream()
            .mapToInt(Car::getMoveCount)
            .max()
            .orElse(Constant.MIN_RANDOM_NUMBER);
    }

    public List<String> getWinnerNames() {
        int maxCount = getMaxCount();
        return cars.getCars().stream()
            .filter(car -> car.getMoveCount() == maxCount)
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
