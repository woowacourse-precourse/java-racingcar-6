package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = ",";

    public List<String> carNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);

        return splitDelimiter(Console.readLine());
    }

    public String tryInputNumber() {
        System.out.println(TRY_INPUT_MESSAGE);

        return Console.readLine();
    }

    private List<String> splitDelimiter(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER)).toList();
    }

}
