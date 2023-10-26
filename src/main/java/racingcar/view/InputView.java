package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String READ_CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private List<String> convertCarNames(String input) {
        return Arrays.stream(input.split(",")).map(String::trim).toList();
    }

    public List<String> readCarNames() {
        System.out.println(READ_CAR_NAMES_INPUT_MESSAGE);
        String input = Console.readLine();
        return convertCarNames(input);
    }
}
