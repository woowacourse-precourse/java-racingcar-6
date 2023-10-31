package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.validation.NameInputValidation;

public class InputView {

    private final NameInputValidation nameInputValidation;

    public InputView(NameInputValidation nameInputValidation) {
        this.nameInputValidation = nameInputValidation;
    }

    public String[] askCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        Arrays.stream(carNames).forEach(nameInputValidation::isUnderFiveLetters);
        return carNames;
    }
}
