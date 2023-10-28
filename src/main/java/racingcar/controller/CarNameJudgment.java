package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.CarObject;

public class CarNameJudgment {
    private List<String> judgmentCarName;
    private List<String> carsName;

    private CarNameJudgment(String carName) {
        this.carsName = Arrays.asList(carName.split(","));

        for (var car : this.carsName) {
            if (carNameSizeJudgment(car) == null) {
                new IllegalArgumentException();
                break;
            }
            judgmentCarName.add(carNameSizeJudgment(car));
        }
    }

    private String carNameSizeJudgment(String carName) {
        if (carName.length() <= CarObject.CAR_NAME_LIMIT_SIZE) {
            return carName;
        }
        return null;
    }

    private List<String> getJudgmentCarName() {
        return judgmentCarName;
    }

    public static List<String> splitOf(String inputCarName) {
        return new CarNameJudgment(inputCarName).getJudgmentCarName();
    }
}
