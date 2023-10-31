package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validator.InputValidator;

public class InputView {
    public static List<String> getCarList() {
        String input = Console.readLine();
        List<String> carList = InputValidator.validateCarsFormat(input);
        InputValidator.validateUniqueCarName(carList);
        InputValidator.validateCarNameValid(carList);
        return carList;
    }

    public static int getTryNumber() {
        String input = Console.readLine();
        InputValidator.validateTryNumber(input);
        return Integer.parseInt(input);
    }
}