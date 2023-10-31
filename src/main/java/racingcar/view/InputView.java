package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.view.constants.Notice.ASK_ATTEMPT_NUMBER;
import static racingcar.view.constants.Notice.ASK_CAR_NAME;

public class InputView {
    public static String askCarName() {
        System.out.println(ASK_CAR_NAME);
        return readLine();
    }

    public static int askAttemptNumber() {
        System.out.println(ASK_ATTEMPT_NUMBER);
        int attemptNumber = Integer.parseInt(readLine());
        validateNumber(attemptNumber);
        return attemptNumber;
    }

    private static void validateNumber(int attemptNumber) {
        if (attemptNumber < 1) {
            throw new IllegalArgumentException("횟수가 올바르지 않습니다.");
        }
    }
}
