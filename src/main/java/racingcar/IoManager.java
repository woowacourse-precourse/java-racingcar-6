package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class IoManager {

    private final static String ENTER_CAR_NAMES= "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String readLine() {
        return Console.readLine();
    }

    public static void printEnterCarName(){
        System.out.println(ENTER_CAR_NAMES);
    }
}
