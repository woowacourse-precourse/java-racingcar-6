package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.validator.InputValidator;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = readLine();

        InputValidator.validateInput(input);
        return input;
    }

    public int inputRaceCount() {
        System.out.println(INPUT_RACE_COUNT_MESSAGE);
        String input = readLine();

        InputValidator.validateRaceCount(input);
        return Integer.parseInt(input);
    }

    private String readLine() {
        return Console.readLine();
    }
}
