package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String GET_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String GET_LOOP_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String getCarsName() {
        System.out.println(GET_CARS_NAME_MESSAGE);
        return Console.readLine();
    }

    public static String getLoopCount() {
        System.out.println(GET_LOOP_COUNT_MESSAGE);
        return Console.readLine();
    }
}
