package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은  쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String COMMA = ",";

    private InputView() {

    }

    private List<String> inputCarNames() {
        System.out.println(INPUT_CARS_NAME);
        String inputCarNames = readLine();
        List<String> carNames = split(inputCarNames);
        return carNames;
    }

    private List<String> split(String input) {
        return Arrays.stream(input.split(COMMA))
                .collect(Collectors.toList());
    }

    private String readLine() {
        return Console.readLine();
    }
}