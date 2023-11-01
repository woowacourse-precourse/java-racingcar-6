package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class IoManager {

    private final static String ENTER_CAR_NAMES= "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ENTER_ROUND_TRY_COUNT= "시도할 회수는 몇회인가요?";
    public static String readLine() {
        return Console.readLine();
    }

    public static void printEnterCarName(){
        System.out.println(ENTER_CAR_NAMES);
    }

    public static void printEnterRoundTryCount(){
        System.out.println(ENTER_ROUND_TRY_COUNT);
    }
}
