package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private final Output output = new Output();
    private final static String delimter = ",";

    // 기본 으로 입력 받는 함수
    private static String getPlayerInput() {
        return Console.readLine();
    }

    // 경주할 자동차 이름을 입력받습니다.
    public String getInputCarNames() {
        output.promptForCarName();
        return getPlayerInput();
    }

    // TODO : 자동차 이름을 유효한지 검사합니다.


    // TODO : 시도할 회수를 입력받습니다.

    // TODO : 시도할 회수가 유효한지 검사합니다.
}
