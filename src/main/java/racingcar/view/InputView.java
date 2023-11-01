package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    static final String ASK_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String ASK_TRY_NUMBER = "시도할 회수는 몇회인가요?";

    public static String askName() {
        System.out.println(ASK_NAME);
        return Console.readLine();
    }

    public static String askTryNumber() {
        System.out.println(ASK_TRY_NUMBER);
        return Console.readLine();
    }
}
