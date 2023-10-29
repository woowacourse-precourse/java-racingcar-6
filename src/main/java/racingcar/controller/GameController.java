package racingcar.controller;

import racingcar.model.Race;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final static int MAX_NAME_LENGTH = 5;

    public void run() {
        String namesInput = InputView.readCarNames();
        validateNamesInput(namesInput);
        Race race = new Race(namesInput);

        String roundInput = InputView.readRoundNumber();
        validateRoundInput(roundInput);
        Round round = new Round(roundInput);

        OutputView.printResultStartMessage();

        while (round.isRemaining()) {
            race.moveCars();
            OutputView.printRoundResult(race);
            round.subtractOne();
        }

        OutputView.printGameWinners(race);
    }

    private void validateNamesInput(String namesInput) {
        String[] inputSplit = namesInput.split(",");
        List<String> nameList = List.of(inputSplit);
        for (String name : nameList) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("빈 이름이 존재함니다.");
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("5글자를 초과한 이름이 입력되었습니다.");
            }
        }
    }

    private void validateRoundInput(String roundInput) {
        int number;
        try {
            number = Integer.parseInt(roundInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력되었습니다.");
        }
        if (number < 1 ) {
            throw new IllegalArgumentException("시도할 회수가 1보다 작습니다.");
        }
    }

}