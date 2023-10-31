package racingcar.controller;

import racingcar.model.Race;
import racingcar.model.RandomGenerator;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Game {
    private final Race race;
    private final Round round;
    private final RandomGenerator randomGenerator;

    public Game() {
        race = new Race();
        round = new Round();
        randomGenerator = new RandomGenerator();
    }

    public void run() {
        setRace();
        setRound();
        printResultStart();

        while (round.isRemaining()) {
            runSingleRound();
            printResult();
            round.subtractOne();
        }

        printResultEnd();
    }

    private void setRace() {
        String namesInput = InputView.readCarNames();
        ValidateInput.validateNamesInput(namesInput);
        race.setCarList(namesInput);
    }

    private void setRound() {
        String roundInput = InputView.readRoundNumber();
        ValidateInput.validateRoundInput(roundInput);
        round.setRound(roundInput);
    }

    private void runSingleRound() {
        int size = race.getCarListSize();
        List<Integer> randomNumbers = randomGenerator.getNumbers(size);
        race.moveCars(randomNumbers);
    }

    private void printResultStart() {
        OutputView.printResultStartMessage();
    }

    private void printResult() {
        List<String> carNames = race.getCarNames();
        List<Integer> roundResult = race.getRoundResult();
        OutputView.printRoundResult(carNames, roundResult);
    }

    private void printResultEnd() {
        List<String> winners = race.getWinners();
        OutputView.printGameWinners(winners);
    }

}