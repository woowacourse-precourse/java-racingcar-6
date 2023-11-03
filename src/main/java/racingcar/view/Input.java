package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final String ASK_RACING_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";

    public String getCarNames() {
        System.out.println(ASK_RACING_CAR_NAMES);
        return Console.readLine();
    }

    public String getNumberOfAttempts() {
        System.out.println(ASK_NUMBER_OF_ATTEMPTS);
        return Console.readLine();
    }
}
