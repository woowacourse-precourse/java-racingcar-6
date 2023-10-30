package racingcar.controller;

import java.util.List;

import racingcar.domain.Race;
import racingcar.domain.RaceCarGarage;
import racingcar.view.Output;

public class RaceController {

    private RaceCarGarage raceCarGarage;
    private Output outPut;
    private Race race;

    public RaceController(List<String> raceCarNames) {
        raceCarGarage = new RaceCarGarage(raceCarNames);
        race = new Race(raceCarGarage.fitInRacingCars());
        outPut = new Output();
    }

    public void round() {
        race.start();
        outPut.printResult(raceCarGarage.fitInRacingCars());
    }

    public void gameOver() {
        outPut.printFinalResult();
    }
}
