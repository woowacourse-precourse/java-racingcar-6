package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String MSG_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MSG_ASKING = "시도할 회수는 몇회인가요?";
    private static final String MSG_RESULT = "실행 결과";

    public static void printStart() {
        System.out.println(MSG_START);
    }

    public static void printAsking() {
        System.out.println(MSG_ASKING);
    }

    public static void printResult() {
        System.out.println(MSG_RESULT);
    }

    public static String getUserInput() {
        return Console.readLine().trim();
    }
}
