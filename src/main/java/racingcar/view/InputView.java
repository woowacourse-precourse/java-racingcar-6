package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.AttemptCountValidator;
import racingcar.util.CarNameValidator;

public class InputView {

    public static int readAttemptCount() {
        OutputView.printAttemptCountPrompt();
        String input = Console.readLine();
        return AttemptCountValidator.validateAttemptCount(input);
    }

    public static String[] readCarNames() {
        OutputView.printCarNamePrompt();
        String input = Console.readLine();
        return CarNameValidator.validateCarNames(input);
    }

}
