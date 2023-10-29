package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.CarObject;

public class CarNameJudgment {
    private ArrayList<String> judgmentCarName;
    private ArrayList<String> carsName;



    private String carNameSizeJudgment(String carName) {
        if (carName.length() <= CarObject.CAR_NAME_LIMIT_SIZE) {
            return carName;
        }
        return null;
    }

    private ArrayList<String> getJudgmentCarName() {
        return judgmentCarName;
    }

    public static ArrayList<String> splitOf(String inputCarName) {
        return new CarNameJudgment(inputCarName).getJudgmentCarName();
    }
}
