package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REQUEST_ROUNDS_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String requestCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carNames = Console.readLine();
        Console.close();
        return carNames;
    }

    public static String requestRounds() {
        System.out.println(REQUEST_ROUNDS_MESSAGE);
        String rounds = Console.readLine();
        Console.close();
        return rounds;
    }
}
