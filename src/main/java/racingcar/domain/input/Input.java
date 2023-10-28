package racingcar.domain.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.input.error.InputError;
import racingcar.domain.input.error.InputException;
import racingcar.util.FormatUtil;

public class Input {

    public static List<String> bringNames() {
        String name = Console.readLine();
        return FormatUtil.devideToList(name);
    }

    public static int bringTrialAmount() {
        String trialAmount = Console.readLine();
        try {
            return Integer.parseInt(trialAmount);
        } catch (InputException e) {
            throw new InputException(InputError.MUST_BE_NUMBER);
        }
    }
}
