package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.validation.MoveCountInputValidation;
import racingcar.validation.NameInputValidation;

public class InputView {

    private final NameInputValidation nameInputValidation;
    private final MoveCountInputValidation moveCountInputValidation;

    public InputView(NameInputValidation nameInputValidation, MoveCountInputValidation moveCountInputValidation) {
        this.nameInputValidation = nameInputValidation;
        this.moveCountInputValidation = moveCountInputValidation;
    }

    public String[] askCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        Arrays.stream(carNames).forEach(nameInputValidation::isUnderFiveLetters);
        return carNames;
    }

    public int askMoveCount() {
        return -1;
    }
}
