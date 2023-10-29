package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class Car {
    private static List<String> name;

    public Car() {

        name = splitCarNames();
    }

    public List<String> getCarName() {
        return name;
    }

    private static List<String> splitCarNames() {
        String carName = InputView.inputCarName();
        return new ArrayList<>(Arrays.asList(carName.split(",")));
    }
}
