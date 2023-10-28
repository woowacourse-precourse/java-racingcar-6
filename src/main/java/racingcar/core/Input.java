package racingcar.core;

import static camp.nextstep.edu.missionutils.Console.*;

public class Input {
    private final static String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_MAX_TRY = "시도할 회수는 몇회인가요?";
    public String readNames(){
        System.out.println(INPUT_CARS_NAME);
        return readLine();
    }
    public int readTryNum(){
        System.out.println(INPUT_MAX_TRY);
        return Integer.parseInt(readLine());
    }
}
