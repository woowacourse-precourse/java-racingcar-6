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

}
