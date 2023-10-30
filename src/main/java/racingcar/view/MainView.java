package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.common.Convert;

public class MainView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMP_MESSAGE = "시도할 회수는 몇회인가요?";
    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }


    public static List<String> getCarNames() {
        String carNames = Console.readLine();
        return Convert.stringToListByComma(carNames);
    }

    public static void printInputAttemptMessage() {
        System.out.println(INPUT_ATTEMP_MESSAGE);
    }

    public static Integer getAttemptNumber() {
        String attemptNumber = Console.readLine();
        return Convert.stringToInteger(attemptNumber);
    }
}
