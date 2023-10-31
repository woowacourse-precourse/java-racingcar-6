package racingcar.view;

import static racingcar.exception.InputException.emptyException;
import static racingcar.exception.InputException.outOfNameLengthException;
import static racingcar.exception.InputException.outOfRangeException;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputVeiw {

    public static List<String> inputMultipleNames() {
        List<String> stringList = Arrays.stream(Console.readLine()
                .split(",")).toList();
        stringList.forEach(InputVeiw::validateSingleName);
        return stringList;
    }

    public static Integer inputSingleNumber() {
        String number = Console.readLine();
        InputVeiw.validateSingleNumber(number);
        return Integer.parseInt(number);
    }

    private static void validateSingleName(String name) {
        emptyException(name);
        outOfNameLengthException(name);
    }

    private static void validateSingleNumber(String number) {
        emptyException(number);
        outOfRangeException(number);
    }

}
