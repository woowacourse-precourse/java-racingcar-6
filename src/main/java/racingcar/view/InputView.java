package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.validator.InputValidator;

public class InputView {
    public static List<String> inputCarNames() {

        List<String> namesList = new ArrayList<String>();
        try {
            String names = Console.readLine();
            InputValidator.isValidCarName(names);
            namesList = List.of(names.split(","));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid input");
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input");
        }
        return namesList;
    }

    public static int inputAttempts() {
        try {
            String attempts = Console.readLine();
            InputValidator.isValidAttempts(attempts);
            return Integer.parseInt(attempts);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}
