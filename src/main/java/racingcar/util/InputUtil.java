package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputException;

import java.util.List;

import static racingcar.constant.ExceptionMessage.*;
import static racingcar.constant.StringConstant.*;

public class InputUtil {
    public InputUtil() {
    }

    public String input() {
        return Console.readLine();
    }

    public List<String> getCarNames() {
        String input = input();
        InputException.checkContainComma(input);
        List<String> names = splitString(input);
        InputException.checkCarCount(names);
        names.forEach(this::validateCarName);
        return InputException.checkDuplicationName(names);
    }

    public int getRound() {
        String input = input();
        int number = stringToInt(input);
        InputException.checkNumber(number);
        return number;
    }

    public int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INPUT_ERROR_NUMBER_TYPE_MESSAGE.getMessage());
        }
    }

    public void validateCarName(String name){
        InputException.checkNameLength(name);
        InputException.checkContainSpace(name);
        InputException.checkNameType(name);
    }

    public List<String> splitString(String input) {
        String[] split = input.split(COMMA.getMessage());
        return List.of(split);
    }
}
