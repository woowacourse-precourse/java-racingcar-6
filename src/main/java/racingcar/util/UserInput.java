package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    Validation validation = new Validation();

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
