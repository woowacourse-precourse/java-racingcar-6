package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public final String ANNOUNCEMENT_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final int MAX_CAR_NAME_LENGTH = 5;
    private final String INPUT_WRONG_VALUE = "잘못된 입력값입니다.";

    public Game() {
        init();
    }

    private void init() {
        System.out.println(this.ANNOUNCEMENT_INPUT_CAR_NAMES);
        String[] carNameArray = Console.readLine().split(",");
        for (String s : carNameArray) {
            if (s.length() > this.MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(this.INPUT_WRONG_VALUE);
            }
            if (s.isEmpty()) {
                throw new IllegalArgumentException(INPUT_WRONG_VALUE);
            }
        }
    }

}
