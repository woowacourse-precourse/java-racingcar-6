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
        List<String> carsList = inputView.getCarNamesInput();
        race.registerCar(carsList);
    }

    private void registerMoveCounts() {
        int moveCounts = inputView.getMoveCountsInput();
        race.registerMoveCounts(moveCounts);
    }

    private void initCarRacing() {
        System.out.println("\n실행 결과");
        while (!race.isRaceOver()) {
            race.startCarRacing();
            outputView.printCars(race.getParticipatingCars());
        }
    }

    private void endCarRacing() {
        outputView.printWinners(race.calculateWinners());
    }
}
