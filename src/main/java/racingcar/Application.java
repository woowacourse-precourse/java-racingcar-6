package racingcar;

import java.util.List;

public class Application {
    private static UserInputException userInputException;
    private static InputView inputView;
    private static List<String> carNames;
    private static int attemptCount;

    public static void main(String[] args) {
        userInputException = new UserInputException();
        inputView = new InputView(userInputException);
        carNames = inputView.getCarName();
        attemptCount = inputView.getAttemptCount();
    }
}
