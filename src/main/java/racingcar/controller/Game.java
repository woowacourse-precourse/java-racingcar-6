package racingcar.controller;

import racingcar.model.Race;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Game {
    private final Race race;
    private final Round round;

    public Game() {
        race = new Race();
        round = new Round();
    }

    public void run() {
        String namesInput = InputView.readCarNames();
        ValidateInput.validateNamesInput(namesInput);
        race.setCarList(namesInput);

        String roundInput = InputView.readRoundNumber();
        ValidateInput.validateRoundInput(roundInput);
        round.setRound(roundInput);

        OutputView.printResultStartMessage();
        List<String> carNames = race.getCarNames();

        while (round.isRemaining()) {
            race.moveCars();

            List<Integer> roundResult = race.getRoundResult();
            OutputView.printRoundResult(carNames, roundResult);

            round.subtractOne();
        }

        List<String> winners = race.getWinners();
        OutputView.printGameWinners(winners);
    }

}