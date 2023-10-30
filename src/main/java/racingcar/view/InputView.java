package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.AttemptCountsInputValidator;
import racingcar.utils.CarNamesInputValidator;

public class InputView {
    private static final String READ_CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String READ_ATTEMPT_COUNTS_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String readCarNames() {
        System.out.println(READ_CAR_INPUT_MESSAGE);
        String carNamesInput = Console.readLine();
        CarNamesInputValidator.validate(carNamesInput);
        return carNamesInput;
    }

    public int readAttemptCounts() {
        System.out.println(READ_ATTEMPT_COUNTS_INPUT_MESSAGE);
        String attemptCounts = Console.readLine();
        AttemptCountsInputValidator.validate(attemptCounts);
        return Integer.parseInt(attemptCounts);
    }
}
