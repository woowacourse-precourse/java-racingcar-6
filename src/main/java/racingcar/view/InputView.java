package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InputView {
    private static final String RACING_CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final int INITIAL_COUNT_VALUE = 0;

    public Map<String, Integer> inputCarName() {
        System.out.println(RACING_CAR_NAME_INPUT_MESSAGE);
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .collect(Collectors.toMap(
                        key -> key,
                        value -> INITIAL_COUNT_VALUE,
                        (existingValue, newValue) -> existingValue,
                        HashMap::new
                ));
    }
}
