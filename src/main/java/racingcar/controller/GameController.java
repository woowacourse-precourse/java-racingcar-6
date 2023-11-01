package racingcar.controller;

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
            cars.carsForwardIfConditionMet();
            race.increaseCurrentTrial();
            outputView.displayRaceStatus(cars);
        }
        outputView.displayWinners(new Winners(cars.getCars()).getWinnersName());
    }

    public List<String> getCarNames() {

        String inputCarNames = inputView.readCarNames();
        return StringParser.splitString(inputCarNames);
    }


}
