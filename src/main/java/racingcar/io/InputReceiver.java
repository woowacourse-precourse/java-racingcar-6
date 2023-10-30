package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputReceiver {
    private static final String QUERY_FOR_CAR_NAMES_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String QUERY_FOR_NUM_OF_TRIES_INPUT = "시도할 회수는 몇회인가요?";

    public String readCarNames() {
        System.out.println(QUERY_FOR_CAR_NAMES_INPUT);
        return Console.readLine();
    }

    public String readNumOfTries() {
        System.out.println(QUERY_FOR_NUM_OF_TRIES_INPUT);
        return Console.readLine();
    }
}
