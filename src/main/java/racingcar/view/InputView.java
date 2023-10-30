package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String inputCarName(){
        System.out.println(CAR_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String inputGameCount(){
        System.out.println(COUNT_INPUT_MESSAGE);
        return Console.readLine();
    }
}
