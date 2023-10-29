package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {
    private final Validation validation = new Validation();

    public String getUserInput() {
        return Console.readLine();
    }

    public List<String> getCarNames() {
        String input = getUserInput();

        return validation.validateCarNames(input);
    }

    public int getGameRound() {
        String input = getUserInput();

        return validation.validateGameRound(input);
    }
}
