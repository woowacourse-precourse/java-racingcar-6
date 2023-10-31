package racingcar;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RaceRound;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private NumberGenerator numberGenerator;

    public GameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {

        Cars cars = prepareRacingCars();

        RaceRound raceRound = prepareRaceRound();

        playRacing(cars, raceRound);

        printWinnerResult(cars);
    }

    private void printWinnerResult(Cars cars) {
        outputView.printWinner(cars.getFurthestCarNameList());
    }

    private void playRacing(Cars cars, RaceRound raceRound) {
        outputView.printRacingResult(cars, raceRound, numberGenerator);
    }

    private RaceRound prepareRaceRound() {
        String stringGameCoin = inputView.readRaceRound();
        return new RaceRound(stringGameCoin);
    }

    private Cars prepareRacingCars() {
        List<String> stringCarName = inputView.readCarName();
        return new Cars(stringCarName);
    }
}
