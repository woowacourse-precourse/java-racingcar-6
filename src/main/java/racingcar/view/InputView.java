package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.exception;

public class InputView {
    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT = "시도할 횟수는 몇회인가요?";

    public static String getInputCar() {
        System.out.println(GAME_START_MESSAGE);
        return Console.readLine();
    }

    public static int getInputAttempt() {
        while (true) {
            try {
                System.out.println(INPUT_ATTEMPT);
                return exception.isValidAttempt(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
