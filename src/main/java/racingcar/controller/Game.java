package racingcar.controller;

import racingcar.model.Race;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Game {

    private final static int MAX_NAME_LENGTH = 5;
    private final Race race;
    private final Round round;

    public Game() {
        race = new Race();
        round = new Round();
    }

    public void run() {
        String namesInput = InputView.readCarNames();
        validateNamesInput(namesInput);
        race.setCarList(namesInput);

        String roundInput = InputView.readRoundNumber();
        validateRoundInput(roundInput);
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

    private void validateNamesInput(String namesInput) {
        String[] inputSplit = namesInput.split(",");
        List<String> nameList = List.of(inputSplit);
        for (String name : nameList) {
            checkNameEmpty(name);
            checkNameLength(name);
        }
    }

    private void checkNameEmpty(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("빈 이름이 존재함니다.");
        }
    }

    private void checkNameLength(String name) throws IllegalArgumentException {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5글자를 초과한 이름이 입력되었습니다.");
        }
    }

    private void validateRoundInput(String roundInput) {
        int number = checkIsNumber(roundInput);
        checkRoundRange(number);
    }

    private int checkIsNumber(String roundInput) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(roundInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력되었습니다.");
        }
        return number;
    }

    private void checkRoundRange(int number) throws IllegalArgumentException {
        if (number < 1 ) {
            throw new IllegalArgumentException("시도할 회수가 1보다 작습니다.");
        }
    }

}