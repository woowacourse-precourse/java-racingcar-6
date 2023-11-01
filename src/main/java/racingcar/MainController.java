package racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    private OutputView outputView;
    private InputView inputView;
    private Race race;

    public MainController(OutputView outputView, InputView inputView, Race race) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.race = race;
    }

    public void startGame() {
        generateCars();
        registerMoveCounts();
        initCarRacing();
        endCarRacing();
    }

    private void generateCars() {
        List<String> carNamesArray = inputView.getCarNamesInput();
        race.registerCar(carNamesArray);
    }

    private void registerMoveCounts() {
        int moveCounts = inputView.getMoveCountsInput();
        race.registerMoveCounts(moveCounts);
    }

    private void initCarRacing() {
        outputView.printStartMessage();
        while (!race.isRaceOver()) {
            race.startCarRacing();
            ParticipatingCars participatingCars = race.getParticipatingCars();
            List<Car> cars = participatingCars.getCars();
            outputView.printCars(cars);
        }
    }

    private void endCarRacing() {
        outputView.printWinners(race.calculateWinners());
    }
}