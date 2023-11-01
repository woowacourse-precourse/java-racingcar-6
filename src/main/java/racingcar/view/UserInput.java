package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.StringError;
import racingcar.domain.Validator;

public class UserInput {

    private UserInput() {
    }

    public static String[] readCarName() {

        String carNames = Console.readLine();

        if (Validator.isEmpty(carNames)) {
            throw new IllegalArgumentException(StringError.REQUIRED_CAR_NAME);
        }

        String[] split = carNames.split(",");
        for (String name : split) {
            if (Validator.isValidCarName(name)) {
                throw new IllegalArgumentException(StringError.CAR_NAME_TOO_LONG);
            }
        }

        return split;
    }

    public static int readRound() {

        String rounds = Console.readLine();

        if (Validator.isNotNumber(rounds)) {
            throw new IllegalArgumentException(StringError.REQUIRED_NUMBER);
        }
        return Integer.parseInt(rounds);
    }
}
