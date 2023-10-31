package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.vo.RacingPreference;

public class InputView {

    private static final String USER_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String USER_INPUT_SEPARATOR = ",";
    private static final String USER_INPUT_ATTEMPT = "시도할 회수는 몇 회 인가요?";
    private static final String LINE_BREAK = "";
    private static final int MAXIMUM_CAR_NAME = 5;


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
        validateAttempt(attempt);

        return new RacingPreference(cars, Integer.parseInt(attempt));
    }

    public void validateCarName(String[] cars) {
        for (String carName : cars) {
            if (carName.length() > MAXIMUM_CAR_NAME) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateAttempt(String attempt) {
        try {
            Integer.parseInt(attempt);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
