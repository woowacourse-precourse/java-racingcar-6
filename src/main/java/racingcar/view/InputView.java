package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_PROMPT = "시도할 회수는 몇회인가요?";

    public static List<String> inputCarNames() {
        System.out.println(CAR_NAME_PROMPT);
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public static int inputTryCount() {
        System.out.println(TRY_COUNT_PROMPT);
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

}
