package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static List<String> inputName() {
        System.out.println(NAME_INPUT_MESSAGE);
        String[] split = Console.readLine().split(",");
        return Arrays.stream(split)
                .collect(Collectors.toList());
    }

    public static int inputAttempt() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

}
