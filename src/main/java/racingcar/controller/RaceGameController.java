package racingcar.controller;

import racingcar.domain.Referee;
import racingcar.service.RaceGameService;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {

    private final InputView inputView = new InputView();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final RaceGameService raceGameService = new RaceGameService(randomNumberGenerator);
    private final OutputView outputView = new OutputView();
    private final Referee referee = new Referee();

    public void startRaceGame() {
        String[] carNames = getCarNamesFromUser();
        raceGameService.initializeCars(carNames);
        int maxRound = getProgressCountFromUser();
        raceGameService.startRace(maxRound, outputView);
        displayWinners();
    }

    private String[] getCarNamesFromUser() {
        outputView.printCarNameInputPrompt();
        return inputView.readCarName();
    }

    private int getProgressCountFromUser() {
        outputView.printCarProgressCountInputPrompt();
        return inputView.readProgressCount();
    }

    private void displayWinners() {
        String winners = raceGameService.getWinners(referee);
        outputView.printGameWon(winners);
    }
}
