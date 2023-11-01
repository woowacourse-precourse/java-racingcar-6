package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.service.RacingcarService;
import racingcar.util.CarNameParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingcarController {

    private final RacingcarService racingcarService;
    private final InputView inputView;
    private final OutputView outputView;
    public RacingcarController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        Race race = initRace();
        this.racingcarService = new RacingcarService(race);
    }
    private Race initRace() {
        String carNamesInput = inputView.readCarNames();
        List<String> carNames = CarNameParser.parse(carNamesInput);
        List<Car> cars = Car.createCars(carNames);

        String roundInput = inputView.readRound();
        int rounds = Integer.parseInt(roundInput);

        return new Race(cars, rounds);
    }
    public void startGame() {
        runRace();
    }

    private void runRace() {
        while (!racingcarService.isRaceFinished()) {
            racingcarService.raceRound();
            String raceStatus = racingcarService.getRaceStatus();
            outputView.printGameStatus(raceStatus);
        }
    }
}
