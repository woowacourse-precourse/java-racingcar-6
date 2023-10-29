package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.Validator;

public class InputView {

    private final Validator validator;
    private static final String CARS_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String SEPARATOR = ",";

    public InputView(Validator validator) {
        this.validator = validator;
    }

    public List<String> readCarNames() {
        System.out.println(CARS_NAME_INPUT_MESSAGE);
        String input = Console.readLine();
        validator.validationCarName(input);
        return Arrays.asList(input.split(SEPARATOR));
    }

    public int readMoveCount() {
        System.out.println(COUNT_MESSAGE);
        String input = Console.readLine();
        validator.validationTrial(input);
        return Integer.parseInt(input);
    }
}
