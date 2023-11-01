package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.Validator;

public class InputView {
    private static final String ERROR_INVALID_ATTEMPTS = "시도 횟수는 숫자로 입력해주세요.";

    public List<String> inputCarNames() {
        String input = Console.readLine();
        List<String> carNames = splitCarNames(input);
        Validator.validateCarNames(carNames);
        return carNames;
    }

    private List<String> splitCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int inputAttemptsNumber() {
        String input = Console.readLine();
        int attempts;
        try {
            attempts = Integer.parseInt(input);
            Validator.validateAttemptsNumber(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_ATTEMPTS);
        }
        return attempts;
    }
}
