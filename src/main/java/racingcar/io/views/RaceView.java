package racingcar.io.views;

import java.util.List;
import racingcar.collaborator.race.Racer;
import racingcar.io.Input;
import racingcar.io.Output;

public class RaceView {

    public List<Racer> askRacersNames() {
        Output.consoleLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Input.consoleStrings(",").stream()
                .map(Racer::new)
                .toList();
    }

}
