package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.InputParser;
import racingcar.utils.InputValidator;

public class InputView {

    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_PROMPT = "시도할 회수는 몇회인가요?";

    public List<String> inputCarNames() {
        System.out.println(CAR_NAME_PROMPT);
        String input = Console.readLine();
        List<String> carNames = InputParser.parseCarNames(input);
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public int inputAttemptCount() {
        System.out.println(ATTEMPT_COUNT_PROMPT);
        String input = Console.readLine();
        InputValidator.validateAttemptCount(input);
        return Integer.parseInt(input);
    }

}
