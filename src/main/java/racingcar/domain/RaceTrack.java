package racingcar.domain;

import java.util.List;

import racingcar.view.OutputView;

public record RaceTrack(RaceCars raceCars) {

    public void executeSingleRaceRound() {
        raceCars.moveCars();
        printRaceStatus();
    }

    public List<RaceCar> getWinners() {
        return raceCars.getWinners();
    }

    private void printRaceStatus() {
        OutputView.printCurrentRaceStatus(raceCars.raceCars());
    }
}
