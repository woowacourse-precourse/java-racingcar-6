package racingcar.controller;

import racingcar.model.Racer;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {

    private String carNames;
    private List<String> racersNames;
    private List<Racer> racers;

    public void play() {
        OutputView.printInputRacersNameMessage();
        carNames = InputView.readRacersName();
        racersNames = RacerManager.seperateRacersName(carNames);
        racers = RacerManager.createRacers(racersNames);



    }
}
