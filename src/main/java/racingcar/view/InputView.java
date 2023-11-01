package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String inputCarNames() {
        System.out.println(INPUT_NAME_MESSAGE);
        String inputCarNames = Console.readLine();
        return inputCarNames;
    }

    public static String inputRound() {
        System.out.println(INPUT_TRIAL_COUNT_MESSAGE);
        String trialCount = Console.readLine();
        return trialCount;
    }
}