package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Car;

public class AppController {

    public AppController() {

        InitGame initSet = new InitGame();

        final ArrayList<Car> classList = initSet.getClassList();
        final int count = initSet.getCount();

        Result result = new Result(classList, count);

    }

}
