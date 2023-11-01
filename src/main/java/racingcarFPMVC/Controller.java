package racingcarFPMVC;

import racingcarFPMVC.InputView;
import racingcarFPMVC.OutputView;
import racingcarFPMVC.Race;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private Race race;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startRacing() {
        List<String> carNames = inputView.getCarNames();
        int tries = inputView.getNumberOfTries();

        race = new Race(carNames, tries);
        System.out.println("실행 결과");
        for (int i = 0; i < race.getTries(); i++) {
            race.moveCars();
            outputView.printCarDistances(race.getCars());
        }

        List<String> winners = race.findWinners();
        outputView.printWinners(winners);
    }
}


