package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.vo.RacingPreference;

public class InputView {

    private static final String USER_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String USER_INPUT_SEPARATOR = ",";
    private static final String USER_INPUT_ATTEMPT = "시도할 회수는 몇 회 인가요?";
    private static final String LINE_BREAK = "";
    private static final int MAXIMUM_CAR_NAME = 5;
    private static final int ATTEMPT_LIMIT = 0;


    public RacingPreference startInfo() {
        System.out.println(USER_INPUT_CAR_NAME);
        String[] cars = Console.readLine().split(USER_INPUT_SEPARATOR);
        System.out.println(USER_INPUT_ATTEMPT);
        String attempt = Console.readLine();
        System.out.println(LINE_BREAK);

        return startInfo(cars, attempt);
    }

    private RacingPreference startInfo(String[] cars, String attempt) {
        validateCarName(cars);
        int AttemptNumber = validateAttemptOnlyNumber(attempt);
        validateAttemptNormalInput(AttemptNumber);

        return new RacingPreference(cars, AttemptNumber);
    }

    public void validateCarName(String[] cars) {
        for (String carName : cars) {
            if (carName.length() > MAXIMUM_CAR_NAME) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int validateAttemptOnlyNumber(String attempt) {
        int attemptNumber;
        try {
            attemptNumber = Integer.parseInt(attempt);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return attemptNumber;
    }

    public void validateAttemptNormalInput(int AttemptNumber) {
        if (AttemptNumber <= ATTEMPT_LIMIT) {
            throw new IllegalArgumentException();
        }
    }
}
