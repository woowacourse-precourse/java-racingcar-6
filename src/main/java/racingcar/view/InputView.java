package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import racingcar.util.InputParser;
import racingcar.util.Validator;

public class InputView {
    private static final String RACING_CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public Map<String, Integer> inputCarName() {
        System.out.println(RACING_CAR_NAME_INPUT_MESSAGE);
        String input = Console.readLine();
        Validator.verifyCarNames(InputParser.parseCarNameList(input));
        return InputParser.parseCarMap(input);
    }

    public int inputTrialCount() {
        System.out.println(TRIAL_COUNT_INPUT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}
