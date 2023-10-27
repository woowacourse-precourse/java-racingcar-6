package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";

    public String carNamesInput() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return Console.readLine();
    }
}
