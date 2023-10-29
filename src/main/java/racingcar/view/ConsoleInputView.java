package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.constant.Message.*;

public class ConsoleInputView implements InputView {
    @Override
    public String askCarNames() {
        System.out.println(ASK_CAR_NAMES.getValue());
        return readLine();
    }

    @Override
    public String askRound() {
        System.out.println(ASK_ROUND.getValue());
        return readLine();
    }
}
