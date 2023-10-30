package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.MessageConst;
import racingcar.util.Validator;

public class InputView {
    public String inputCarNames() {
        System.out.println(MessageConst.INPUT_NAME_MSG);
        String carNames = Console.readLine();
        Validator.getValidatedCarName(carNames);
        return carNames;
    }

    public int inputAttemptCount() {
        System.out.println(MessageConst.INPUT_ATTEMPT_MSG);
        String attemptCount = Console.readLine();
        Validator.getValidatedAttemptCount(attemptCount);
        return Integer.parseInt(attemptCount);
    }
}
