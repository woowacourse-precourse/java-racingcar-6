package racingcar.controller;

import racingcar.model.Race;
import racingcar.model.Round;
import racingcar.view.OutputView;

import java.util.List;

public class GameProgress {
    private Race race;
    private Round round;
    private OutputView outputView;

    public GameProgress(Race race, Round round, OutputView outputView) {
        this.race = race;
        this.round = round;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = race.getCarNames();
        outputView.printResultStart();

        while(round.isRemaining()) {
            race.moveCars();

            List<Integer> roundResult = race.getRoundResult();
            outputView.printRoundResult(carNames, roundResult);

            round.subtractOne();
        }
        List<String> winners = race.getWinners();
        outputView.printWinners(winners);
    }
}
