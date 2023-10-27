package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarGameView {

    private static final String START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public RacingCarGameView() {

    }

    public String inputCarNames() {
        System.out.println(START);
        String inputNames = Console.readLine();

        return inputNames;
    }
}
