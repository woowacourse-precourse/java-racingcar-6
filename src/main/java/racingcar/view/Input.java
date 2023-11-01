package racingcar.view;

import racingcar.exception.InputCarException;
import racingcar.exception.InputRoundException;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public static List<String> carNames() {
        String namesInput = Console.readLine();
        List<String> nameList = List.of(namesInput.split(","));

        nameList = nameList.stream().distinct().collect(Collectors.toList());

        InputCarException.numberOfCarException(nameList);
        InputCarException.removeWhitespace(nameList);
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