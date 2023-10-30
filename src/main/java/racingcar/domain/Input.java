package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    public static List<String> readCarName() {
        String input = Console.readLine();
        List<String> carNames = InputValidation.checkCharacter(input);
        InputValidation.checkOverlap(carNames);
        InputValidation.checkNameLength(carNames);
        return carNames;
    }

    public static int readMoveCount() {
        String input = Console.readLine();
        int moveCount = InputValidation.checkNumber(input);
        return moveCount;
    }
}
