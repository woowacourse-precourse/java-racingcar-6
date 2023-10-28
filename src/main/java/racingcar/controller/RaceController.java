package racingcar.controller;

import java.util.List;
import racingcar.domain.CarName;
import racingcar.domain.CarNames;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void runGame() {
        CarNames carNames = CarNames.from(inputView.readCarNames());
        TryCount tryCount = new TryCount(inputView.readTryCount());
        startRace(carNames, tryCount);
    }

    private void startRace(CarNames carNames, TryCount tryCount) {
        outputView.printRaceResultMessage();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            // TODO: (1) 자동차 움직이기 (2) 각 자동차 결과 출력하기
        }
    }
}
