package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String ASK_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";

    public static String getCarNameList() {
        System.out.println(ASK_CAR_NAME);
        return Console.readLine();
    }

    public static String getAskNumberOfAttempts() {
        System.out.println(ASK_NUMBER_OF_ATTEMPTS);
        return Console.readLine();
    }
}
