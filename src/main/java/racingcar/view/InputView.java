package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String CAR_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ROUND_INPUT = "시도할 회수는 몇회인가요?";

    public static String carInput() {
        printView(CAR_INPUT);
        return Console.readLine();
    }

    public static String roundInput() {
        printView(ROUND_INPUT);
        return Console.readLine();
    }

    private static void printView(String view){
        System.out.println(view);
    }
}
