package racingcar.controller;

import racingcar.model.InputUtil;
import racingcar.view.RaceStartView;

public class GameController {

    public void run() {
        RaceStartView raceStartView = new RaceStartView();

        String carName = raceStartView.getCarName();
        String[] carNameStrings = InputUtil.splitCarName(carName);

        String raceLap = raceStartView.getRaceLap();
    }
}
