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
        return cars.getMaxCount();
    }

    public List<String> getWinnerNames() {
        return cars.getWinners(getMaxCount());
    }
}
