package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.util.Utils.splitString;
import static racingcar.util.Validator.validateDuplication;
import static racingcar.view.OutputView.printGameNotice;
import static racingcar.view.constants.GameNotice.PROMPT_CAR_NAMES;
import static racingcar.view.constants.GameNotice.PROMPT_ROUNDS;

import java.util.List;

public class InputView {
    public static List<String> askCarNames() {
        printGameNotice(PROMPT_CAR_NAMES);
        List<String> splitUserInput = splitString(readLine());
        validateDuplication(splitUserInput);
        return splitUserInput;
    }

    public static String askHowManyRounds() {
        printGameNotice(PROMPT_ROUNDS);
        return readLine();
    }
}
