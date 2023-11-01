package racingcar.controller;

import java.util.List;
import racingcar.message.OutputMessage;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.model.WinningResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingGame racingGame = new RacingGame();
    private final WinningResult winningResult = new WinningResult();

    String[] names = inputView.getNames();


    public void start() {

        int rounds = inputView.getRounds();

        List<Car> cars = racingGame.saveCarsInfo(names);

        roundResult(rounds, cars);
        winningResult.winnerScore(cars);
        outputView.winnerResult(cars, winningResult.winningScore);

    }

    public void roundResult(int rounds, List<Car> cars){
        printMessage(OutputMessage.ROUND_RESULT);
        for (int i = 0; i < rounds; i++) {
            racingGame.saveRoundResult(cars);
            outputView.round(cars);
        }
    }

    public void printMessage(String text){
        System.out.println(text);
    }
}
