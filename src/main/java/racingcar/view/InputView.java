package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String COMMA = ",";

    private InputView() {
    }

    public static List<String> inputNames() {
        System.out.println(INPUT_NAME_MESSAGE);
        try {
            String names = Console.readLine();
            return Arrays.asList(names.split(COMMA));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[Error] 잘못된 형식의 자동차 이름이 입력되었습니다.", e);
        }
    }

    public static int inputRound() {
        System.out.println(INPUT_TRIAL_COUNT_MESSAGE);
        try {
            String trialCount = Console.readLine();
            return Integer.parseInt(trialCount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[Error] 잘못된 형식의 시도횟수가 입력되었습니다.", e);
        }
    }
}
