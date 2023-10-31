package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.GameCountValidator;

public class InputView {

    public String inputGameCount() {
        String gameCount = Console.readLine();
        GameCountValidator.validatePositiveDigitAnInRangeGameCount(gameCount);
        return gameCount;
    }
}
