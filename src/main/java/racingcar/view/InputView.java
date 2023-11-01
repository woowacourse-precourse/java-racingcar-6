package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_PROMPT = "시도할 회수는 몇회인가요?";
    private static final String SPLIT_DELIMITER = ",";

    public static List<String> readCarNames() {
        System.out.println(CAR_NAME_PROMPT);
        String input = Console.readLine();
        return Arrays.asList(input.split(SPLIT_DELIMITER));
    }

    public static int readRounds() {
        System.out.println(ROUND_PROMPT);
        String input = Console.readLine();
        System.out.println();
        return Integer.parseInt(input);
    }
}
