package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private static final String ASK_CAR_NAME_INPUT_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private static final String ASK_HOW_MANY_TURN_MSG = "시도할 회수는 몇회인가요?\n";

    public String setInputCarName() {
        System.out.print(ASK_CAR_NAME_INPUT_MSG);
        return Console.readLine();
    }

    public String setInputTurnNumber() {
        System.out.print(ASK_HOW_MANY_TURN_MSG);
        return Console.readLine();
    }
}
