package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ROUND_NUMBER = "시도할 횟수는 몇회인가요?";

    public static String createCarName(){
        System.out.println(CAR_NAME_INPUT);
        return Console.readLine();
    }

    public static String createRoundNumber(){
        System.out.println(ROUND_NUMBER);
        return Console.readLine();
    }
}
