package racingcar.collaborator;

import java.util.List;
import racingcar.io.Input;
import racingcar.io.Output;

public class Race {

    private List<String> racers;

    public void registerRacer() {
        Output.consoleLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racers = Input.consoleStrings(",");
    }

}
