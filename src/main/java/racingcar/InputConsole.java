package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputConsole {

    public static List<String> enterCarNames() {
        List<String> carNames = new ArrayList<>();
        OutputConsole.print(OutputConsole.CAR_NAME_MESSAGE);
        String input = Console.readLine();
        String[] splittedNames = input.split(",");
        for (String splittedName : splittedNames) {
            if (Validator.validateCarName(splittedName)) {
                carNames.add(splittedName.trim());
            }
        }
        return carNames;
    }

    public static int enterRound() {
        OutputConsole.print(OutputConsole.ROUND_MESSAGE);
        String input = Console.readLine();
        int round;
        try {
            round = Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
        return round;
    }

}
