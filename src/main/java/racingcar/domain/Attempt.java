package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

public class Attempt {
    private int count;

    public void startMakeAttemptNumber() {
        InputView.printRequestAttempt();
        String attemptInput = Console.readLine();
        input(attemptInput);
        InputView.printLineChanging();
    }

    public void input(String attemptInput) {
        validateAttemptNumber(attemptInput);
    }

    public void validateAttemptNumber(String number) {
        checkNonBlank(number);
        checkInteger(number);
        checkPositiveNumber();
    }

    public int getCount() {
        return count;
    }

}
