package racingcar.view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {
    // Car 입력받기
    // Round 입력받기
    private static final String CarNameQuestion = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static String requestCarName() {
        System.out.println(CarNameQuestion);
        return Console.readLine();
    }
}
