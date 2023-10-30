package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.view.constants.Notice.ASK_ATTEMPT_NUMBER;
import static racingcar.view.constants.Notice.ASK_CAR_NAME;

public class InputView {
    private static int attemptNumber;

    public static String askCarName() {
        System.out.println(ASK_CAR_NAME);
        return readLine();
    }

    public static int askAttemptNumber() {
        System.out.println(ASK_ATTEMPT_NUMBER);
        attemptNumber = Integer.parseInt(readLine());
        validateNumber();
        return attemptNumber;
    }

    private static void validateNumber() {
        if (attemptNumber < 1) {
            throw new IllegalArgumentException("입력하신 횟수가 올바르지 않습니다.");
        }
    }
}
