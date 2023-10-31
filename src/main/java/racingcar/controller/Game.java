package racingcar.controller;

import racingcar.game.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.IntStream;

import static racingcar.controller.constants.IntegerConstants.*;

public class Game {
    private Integer round;
    private Cars cars;

    public void run(){
        OutputView.startGame();
        cars = new Cars(InputView.readCarNames());
        askGameRounds();
        racing();
        getWinners();
    }

    private void askGameRounds(){
        OutputView.askGameRounds();
        round = Parser.parsingInteger(InputView.readLine());
    }

    private void racing(){
        OutputView.startGameResult();
        IntStream.range(STARTING_POINT.getValue(), round).forEach(roundNumber -> {
            cars.roundRace();
            OutputView.theEndOfRound();
        });
    }

    private void getWinners(){
        cars.getWinners();
    }
}
