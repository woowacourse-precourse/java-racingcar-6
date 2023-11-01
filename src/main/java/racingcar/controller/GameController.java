package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.Winners;
import racingcar.utils.StringParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;
    private Race race;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        setGames();
        startGame();
    }

    public void setGames() {
        outputView.displayCarNamesInputMessage();
        List<String> carNames = getCarNames();
        this.cars = new Cars(carNames);

        outputView.displayNumberOfTrialsQuestion();
        this.race = new Race(inputView.readTrialNumber());
    }

    public void startGame() {

        outputView.displayRoundResultMessage();
        while (!race.currentTrialReachedTotal()) {
            for (Car car : cars.getCars()) {
                car.forwardOrStay(race.pickRandomNumber());
            }
            race.increaseCurrentTrial();
            outputView.displayRaceStatus(cars);
        }
        Winners winners = cars.getWinners();
        outputView.displayWinners(winners.getWinnersName());
    }

    public List<String> getCarNames() {
        String inputCarNames = inputView.readCarNames();
        return StringParser.splitCarNames(inputCarNames);
    }


}
