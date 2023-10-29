package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputMessage {

    private static final String CARNAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String GAME_NUMBER = "시도할 횟수는 몇 회인가요?";

    public static String carName(){
        System.out.println(CARNAME_INPUT);
        return Console.readLine();
    }

    public static String gameNumber(){
        System.out.println(GAME_NUMBER);
        return Console.readLine();
    }

}
