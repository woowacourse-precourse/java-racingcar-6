package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.domain.Name;
import racingcar.domain.RaceCar;
import racingcar.domain.RaceCars;
import racingcar.domain.RaceTrack;

public class RaceGame {
    private RaceTrack raceTrack;
    private int round;

    public void startGame() {
        initializeGame();
        executeRace();
        announceWinners();
    }

    private void initializeGame() {
        List<RaceCar> carNameList = createCarList(readCarNames());
        setRounds();
        initializeRaceTrack(carNameList);
    }

    private void setRounds() {
        this.round = InputView.readRounds();
    }

    private List<String> readCarNames() {
        return InputView.readCarNames();
    }

    private List<RaceCar> createCarList(List<String> carNames) {
        List<RaceCar> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new RaceCar(new Name(name)));
        }
        return carList;
    }

    private void initializeRaceTrack(List<RaceCar> carList) {
        RaceCars raceCars = new RaceCars(carList);
        this.raceTrack = new RaceTrack(raceCars);
    }

    private void executeRace() {
        OutputView.printRaceStartMessage();
        for (int i = 0; i < round; i++) {
            raceTrack.executeSingleRaceRound();
        }
    }

    private void announceWinners() {
        List<RaceCar> winners = raceTrack.getWinners();
        OutputView.printResult(winners);
    }
}
