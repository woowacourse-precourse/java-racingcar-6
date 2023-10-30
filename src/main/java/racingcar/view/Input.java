package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validator.InputValidator;

public class Input {

    public static List<String> getCarNames() {
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public static int getInteger() {
        String input = Console.readLine();
        if (InputValidator.isInteger(input) == false) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
        return Integer.parseInt(input);
    }
}
