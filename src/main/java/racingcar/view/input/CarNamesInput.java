package racingcar.view.input;

import java.util.Arrays;
import java.util.List;

public class CarNamesInput {
    private static final String SPLIT_DELIMETER = ",";
    private static final int SPLIT_LIMIT = -1;

    private final List<String> carNames;

    private CarNamesInput(List<String> carNames) {
        this.carNames = carNames;
    }

    public static CarNamesInput parse(String rawString) {
        return new CarNamesInput(Arrays.asList(rawString.split(SPLIT_DELIMETER, SPLIT_LIMIT)));
    }

    public List<String> carNames() {
        return carNames;
    }
}
