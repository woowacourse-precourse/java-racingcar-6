package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";

    public static String inputNames() {
        System.out.println(INPUT_NAMES);
        return Console.readLine();
    }

    public static String inputAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT);
        return Console.readLine();
    }

    public static void close() {
        Console.close();
    }
}
