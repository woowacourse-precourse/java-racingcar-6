package racingcar;

import java.util.List;
import racingcar.domain.CarRaceJudge;
import racingcar.view.InputView;

public class CarRaceGame {

    private final CarRaceJudge judge = new CarRaceJudge();

    public void startRace() {
        List<String> carNames = InputView.inputCarNames();
        judge.addCars(carNames);
    }


}
