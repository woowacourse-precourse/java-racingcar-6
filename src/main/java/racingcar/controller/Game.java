package racingcar.controller;

import racingcar.game.Cars;
import racingcar.game.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.IntStream;

import static racingcar.controller.constants.IntegerConstants.*;

public class Game {
    private Integer round;
    private Cars cars;

    public void run(){
        askCarNames();
        askGameRounds();
        racing();
        getWinners();
    }

    private void askCarNames(){
        OutputView.askCarNames();
        cars = new Cars(InputView.readCarNames());
    }

    private void askGameRounds(){
        OutputView.askGameRounds();
        String input = InputView.readLine();
        InputValidator.inputMustHaveValue(input);
        InputValidator.inputMustBeInteger(input);
        round = Parser.parsingInteger(input);
        InputView.close();
    }

    private void racing(){
        OutputView.startGameResult();
        IntStream.range(STARTING_POINT.getValue(), round).forEach(roundNumber -> {
            cars.roundRace();
            OutputView.theEndOfRound();
        });
    }

    private void getWinners(){
        OutputView.finalGameResult(cars.winnersToString());
    }
}
