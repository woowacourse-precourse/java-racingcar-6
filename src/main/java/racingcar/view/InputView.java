package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.Utils;
import racingcar.validator.Validator;

public class InputView {
    public static int inputAttemptCount() {
        String attemptValue = Console.readLine();
        Validator.validateIsNumeric(attemptValue);
        Validator.validateNonEmpty(attemptValue);

        int attemptCount = Integer.parseInt(attemptValue);
        Validator.validateAtLeastOne(attemptCount);

        return attemptCount;
    }

    public static List<String> inputCarName() {
        String carNames = Console.readLine();
        Validator.validateSeparatedByComma(carNames);

        List<String> separatedCarNames = Utils.splitAndToList(carNames);
        Validator.validateCarNameLength(separatedCarNames);
        Validator.validateHasDuplicateCarNames(separatedCarNames);

        return separatedCarNames;
    }
}
