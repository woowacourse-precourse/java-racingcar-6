package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.validation.MoveCountInputValidation;
import racingcar.validation.NameInputValidation;

public class InputView {

    private static InputView inputView;
    private final NameInputValidation nameInputValidation = new NameInputValidation();
    private final MoveCountInputValidation moveCountInputValidation = new MoveCountInputValidation();

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public String[] askCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        Arrays.stream(carNames).forEach(nameInputValidation::isUnderFiveLetters);
        return carNames;
    }

    public int askMoveCount() {
        String input = Console.readLine();
        moveCountInputValidation.isNumber(input);
        return Integer.parseInt(input);
    }
}
