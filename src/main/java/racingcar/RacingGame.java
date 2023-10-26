package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;

public class RacingGame {

    public void start() {
        Output.consoleLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racers = Input.consoleLine();
        for (String s : racers.split(",")) {
            System.out.println(s);
        }
    }

}
