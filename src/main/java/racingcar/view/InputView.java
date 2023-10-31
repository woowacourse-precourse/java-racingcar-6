package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.InputValidator;

public class InputView {
    public static final String DELIMITER = ",";
    public List<String> askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();

        return divideCarNames(inputNames);
    }
    public List<String> divideCarNames(String inputNames) {
        List<String> carNames = Arrays.asList(inputNames.split(DELIMITER));
        InputValidator.validateCarNamesSize(carNames);
        InputValidator.validateCarNameLength(carNames);

        return carNames;
    }

    public int askMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputMoveCount = Console.readLine();

        return Integer.valueOf(inputMoveCount);
    }

}
