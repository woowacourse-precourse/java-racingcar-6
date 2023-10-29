package racingcar.utils.io;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    public String receiveCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String input = Console.readLine();
        return input;
    }

    public String receiveRoundNumber() {
        System.out.println(INPUT_ROUND_NUMBER_MESSAGE);
        String input = Console.readLine();
        return input;
    }
}
