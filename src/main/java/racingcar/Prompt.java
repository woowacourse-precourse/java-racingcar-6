package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.RacingConst.CAR_NAME_SPLITTER;

public class Prompt {

    public static String[] readCarNames() {
        String input = readLine();
        String[] carNames = input.split(CAR_NAME_SPLITTER);
        for (String carName : carNames) {
            if (Validator.isNotCarName(carName)) {
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

    public static Integer readMaxTurn() {
        String input = readLine();
        if (Validator.isNotNumber(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }
}
