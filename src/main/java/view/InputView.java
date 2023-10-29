package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import validator.InputValidator;

public class InputView {
    public static String[] inputRacingCarNames() {
        OutputView.printInputRacingCarNamesMessage();
        String[] racingCarNames = Console.readLine().split(",");
        InputValidator.validateRacingCarNames(racingCarNames);
        return racingCarNames;
    }

    public static int inputMoveCount() {
        OutputView.printInputMoveCountMessage();
        String moveCountInput = Console.readLine();
        return Integer.parseInt(moveCountInput);
    }
}
