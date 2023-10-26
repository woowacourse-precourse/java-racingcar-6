package racingcar.collaborator;

import java.util.List;
import racingcar.io.Input;
import racingcar.io.Output;

public class Race {

    private List<String> racers;
    private Integer numberOfRound;

    public void registerRacer() {
        Output.consoleLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racers = Input.consoleStrings(",");
    }

    public void decideRound() {
        Output.consoleLine("시도할 회수는 몇회인가요?");
        numberOfRound = Input.consoleNumber();
    }

}
