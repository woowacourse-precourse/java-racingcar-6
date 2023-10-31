package racingcar.io.views;

import java.util.List;
import racingcar.collaborator.race.Racer;
import racingcar.io.Input;
import racingcar.io.Output;

public class RaceView {

    public List<Racer> askRacersNames() {
        Output.consoleLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // TODO : 이름에 대한 예외처리
        return Input.consoleStrings(",").stream()
                .map(Racer::new)
                .toList();
    }

    public Integer askRoundNumber() {
        Output.consoleLine("시도할 회수는 몇회인가요?");
        // TODO : 회수에 대한 예외처리
        Integer numberOfRound = Input.consoleNumber();
        Output.consoleLine(); // 입력 후 공백 한 줄이 들어가게 되어있음
        return numberOfRound;
    }

}
