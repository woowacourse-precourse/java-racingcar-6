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

    public static List<String> getCarName() {
        return name;
    }

    private static List<String> splitCarNames() {
        List<String> carNameList = new ArrayList<>();
        String carName = InputView.inputCarName();

        carNameList.addAll(Arrays.asList(carName.split(",")));

        return carNameList;
    }
}
