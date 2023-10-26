package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String INPUT_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public void printInputCarsMessage() {
        System.out.println(INPUT_CARS_MESSAGE);
    }

    public String inputCarsName() {
        return Console.readLine();
    }
}
