package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.View.error.Error;
import racingcar.View.error.InputException;

public class Input {

    public int inputInteger() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public String inputString() {
        return Console.readLine();
    }

    public void verifyRoundCount(int Round) {
        if (Round < 1) {
            throw new InputException(Error.ROUND_COUNT_UNDEFIND_ERROR);
        }

        if (Round > 5) {
            throw new InputException(Error.ROUND_COUNT_MAXIMUM_ERROR);
        }
    }


    public void verifyUserName(String[] names) {
        if (names == null || names.length == 0) {
            throw new InputException(Error.USERNAME_UNDEFINED_ERROR);
        }

        for (String name : names) {
            if (name == null || name.trim().isEmpty() || name.length() > 5) {
                throw new InputException(Error.USERNAME_MAXIMUM_ERROR);
            }
        }
    }
}
