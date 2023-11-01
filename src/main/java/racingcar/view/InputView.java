package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.NameValidation;
import racingcar.validator.TryValidation;

public class InputView {
    public String readCarNames() {
        String input = Console.readLine();
        runNameValidator(input);
        return input;
    }

    public String readTryNumber() {
        String number = Console.readLine();
        runTryValidator(number);
        return number;
    }

    private void runNameValidator(String input) {
        NameValidation nameValidation = new NameValidation();
        nameValidation.checkWord(input);
    }

    private void runTryValidator(String input) {
        TryValidation tryValidation = new TryValidation();
        tryValidation.checkTryNumber(input);
    }

}