package racingcar.view;

import racingcar.exception.InputCarException;
import racingcar.exception.InputRoundException;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    public static List<String> carNames() {
        String namesInput = Console.readLine();
        List<String> nameList = List.of(namesInput.split(","));

        InputCarException.numberOfCarException(nameList);
        for (String name : nameList) {
            InputCarException.nameLengthException(name);
        }

        return nameList;
    }

    public static int round() {
        String roundInput = Console.readLine();
        return InputRoundException.notIntegerException(roundInput);
    }
}
