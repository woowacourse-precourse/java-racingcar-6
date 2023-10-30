package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarGame {
    static void printGameStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    static String getUserInput() {
        return Console.readLine();
    }
}
