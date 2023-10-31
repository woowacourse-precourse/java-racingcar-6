package racingcar.service;

import java.util.List;

public class Input {

    private String[] splitCarName(String notSplitCar) {

        String[] carName = notSplitCar.split(",");

        return carName;
    }
}
