package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Controller;
import racingcar.view.InputView;

public class Car {
    private static List<String> name;

    public Car(String carName) {
        name = splitCarNames(carName);
    }

    public static List<String> getCarName() {
        return name;
    }

    private static List<String> splitCarNames(String carName) {
        return new ArrayList<>(Arrays.asList(carName.split(",")));
    }

    public static String moveCount() {
        StringBuilder dash = new StringBuilder();

        if (Controller.makeMoveDecision()) {
            dash.append("-");
        }
        return dash.toString();
    }
}
