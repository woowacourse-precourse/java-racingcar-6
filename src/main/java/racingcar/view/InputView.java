package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.CarNameValidator;

public class InputView {

    private static final String NAME_DELIMITER = ",";

    public static List<String> getCarNames() {
        String carNames = getUserInput();
        String[] splitNames = splitCarNames(carNames);
        CarNameValidator.validateCarNames(splitNames);
        return new ArrayList<>(Arrays.asList(splitNames));
    }

    public static String getUserInput() {
        return Console.readLine();
    }

    public static String[] splitCarNames(String carNames) {
        return carNames.split(NAME_DELIMITER);
    }
}
