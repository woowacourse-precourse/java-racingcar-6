package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static String RACING_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String ATTEMPT_QUESTION = "시도할 회수는 몇회인가요?";

    public static int setRaceAttempts() {
        System.out.println(ATTEMPT_QUESTION);
        return Integer.parseInt(Console.readLine());
    }

    public static String getCarName() {
        System.out.println(RACING_START);
        return Console.readLine();
    }
}
