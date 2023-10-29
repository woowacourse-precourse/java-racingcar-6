package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.AttemptCountValidator;
import racingcar.util.CarNameValidator;

public class InputView {

    public static String readAttemptCount(){
        OutputView.printAttemptCountPrompt();
        String input = Console.readLine();
        return input;
    }

    public static String[] readCarNames(){
        OutputView.printCarNamePrompt();
        String input = Console.readLine();
        return CarNameValidator.validateCarNames(input);
    }

}
