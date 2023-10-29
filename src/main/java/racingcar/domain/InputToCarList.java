package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputToCarList {

    private static class SingletonHelper {
        private static final InputToCarList INSTANCE = new InputToCarList();
    }

    public static InputToCarList getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private InputToCarList() {
    }

    public List<Car> askCarName(final String input) {
        List<Car> list = Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());

        return list;
    }
}
