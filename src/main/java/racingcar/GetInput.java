package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.Validation.*;

public class GetInput {

    public static String getCarNames() {
        return Console.readLine();
    }

    public static int getCounts() {
        String input = Console.readLine();
        return validateCounts(input);
    }

}
