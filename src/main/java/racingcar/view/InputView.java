package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> enterCarsName() {
        String names = Console.readLine();
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .toList();
    }

    public static int enterMovesNumber() {
        String input = Console.readLine()
                .trim();
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
