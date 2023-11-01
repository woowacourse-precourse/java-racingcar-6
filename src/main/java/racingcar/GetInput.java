package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.Validation.*;

public class GetInput {

    public static String getCarNames() {
        String input = Console.readLine();
        checkCarNameInput(input);
        return input;
    }

    public static int getCounts() {
        String input = Console.readLine();
        return validateCounts(input);
    }

}
