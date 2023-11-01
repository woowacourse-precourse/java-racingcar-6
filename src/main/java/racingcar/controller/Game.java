package racingcar.controller;

import racingcar.game.Cars;
import racingcar.game.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.IntStream;

import static racingcar.controller.constants.IntegerConstants.*;

public class Game {
    public Integer round;
    public Cars cars;

    public void run(){
        askCarNames();
        askGameRounds();
        racing();
        getWinners();
    }

    public void askCarNames(){
        OutputView.askCarNames();
        cars = new Cars(InputView.readCarNames());
    }

    public void askGameRounds(){
        OutputView.askGameRounds();
        String input = InputView.readLine();
        InputValidator.mustHaveValue(input);
        InputValidator.mustBeInteger(input);
        round = Parser.parsingInteger(input);
        InputView.close();
    }

    public void racing(){
        OutputView.startGameResult();
        IntStream.range(STARTING_POINT.getValue(), round).forEach(roundNumber -> {
            cars.roundRace();
            OutputView.theEndOfRound();
        });
    }

    public void getWinners(){
        OutputView.finalGameResult(cars.winnersToString());
    }
}
