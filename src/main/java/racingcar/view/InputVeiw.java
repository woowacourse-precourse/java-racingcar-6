package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputException;

import java.util.Arrays;
import java.util.List;

import static racingcar.exception.InputException.emptyException;
import static racingcar.exception.InputException.outOfRangeException;
import static racingcar.exception.InputException.outOfNameLengthException;

public class InputVeiw {

    public static List<String> inputCarNameList() {
        List<String> carNameList = Arrays.stream(Console.readLine()
                .split(",")).toList();

        carNameList.forEach(InputVeiw::validateNameInput);

        return carNameList;
    }

    public static Integer inputRoundNumber() {
        String roundNumber = Console.readLine();

        InputVeiw.validateNumberInput(roundNumber);

        return Integer.parseInt(roundNumber);
    }

    private static void validateNameInput(String name) {
        emptyException(name);
        outOfNameLengthException(name);
    }

    private static void validateNumberInput(String number) {
        emptyException(number);
        outOfRangeException(number);
    }

}
