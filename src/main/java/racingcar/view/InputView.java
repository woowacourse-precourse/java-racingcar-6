package racingcar.view;

import static racingcar.utils.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;


public class InputView {
    public static List<String> inputCarNames() {
        String carstr = Console.readLine();
        validateCarInput(carstr);
        List<String> carNames = Arrays.stream(carstr.split(","))
                .map(String::trim)
                .toList();
        return carNames;
    }

    public static void validateCarInput(String carstr) {
        if (carstr.contains(",")) {
            return;
        }
        throw new IllegalArgumentException(INVALID_SPLIT_CHAR.getMessage());
    }

    public static int inputAttempNum() {
        try {
            int attempNum = Integer.parseInt(Console.readLine());
            return attempNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_DIGIT_ATTEMP_NUM.getMessage());
        }
    }

}
