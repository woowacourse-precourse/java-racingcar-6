package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.CarNames;
import racingcar.util.InputValidator;

public class InputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = ",";

    public CarNames askCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String inputNames = Console.readLine();

        return divideCarNames(inputNames);
    }

    public CarNames divideCarNames(String inputNames) {
        List<String> names = Arrays.asList(inputNames.split(DELIMITER));
        InputValidator.validateCarNamesSize(names);
        InputValidator.validateCarNameLength(names);

        CarNames carNames = new CarNames(names);

        return carNames;
    }

    public int askMoveCount() {
        System.out.println(MOVE_COUNT_INPUT_MESSAGE);
        String inputMoveCount = Console.readLine();

        return Integer.valueOf(inputMoveCount);
    }
}
