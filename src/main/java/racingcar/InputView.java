package racingcar;

import static racingcar.Constant.SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private final UserInputException userInputException; // 사용자 입력을 검증

    public InputView(UserInputException userInputException) {
        this.userInputException = userInputException;
    }

    public List<String> getCarName() {
        String[] carNames = Console.readLine().split(SEPARATOR);
        validateCarName(carNames);
        return List.of(carNames);
    }

    private void validateCarName(String[] carNames) {
        userInputException.validateUniqueCarName(carNames);
        userInputException.validateBlankCarName(carNames);
        userInputException.validateCarNameLength(carNames);
    }

    public int getAttemptCount() {
        String userInput = Console.readLine();
        return validateAttemptCount(userInput);
    }

    private int validateAttemptCount(String userInput) {
        int attemptCount = userInputException.isIntegerAttemptCount(userInput);
        userInputException.validateAttemptCountRange(attemptCount);
        return attemptCount;
    }
}
