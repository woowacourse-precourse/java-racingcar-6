package racingcar.view;

import static racingcar.utils.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;


public class InputView {
    public List<String> inputCarNames() {
        String carstr = Console.readLine();
        validateCarInput(carstr);
        List<String> carNames = Arrays.stream(carstr.split(","))
                .map(String::trim)
                .toList();
        return carNames;
    }

    public void validateCarInput(String carNames) {
        if (carNames.contains(",")) {
            return;
        }
        throw new IllegalArgumentException(INVALID_CAR_NUM.getMessage());
    }

    public int inputAttemptNumber() {
        try {
            int attemptNumber = Integer.parseInt(Console.readLine());
            return attemptNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_DIGIT_ATTEMP_NUM.getMessage());
        }
    }

}
