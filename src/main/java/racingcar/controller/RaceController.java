package racingcar.controller;

import static racingcar.util.GameResult.getInstance;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    public void run() {
        InputView view = new InputView();
        String carNames = view.inputCarNames();
        Integer tryCount = view.inputHowManyTry();

        RacingCarGame racingCarGame = new RacingCarGame(new Referee(), new RaceController());
        List<Car> resultList = racingCarGame.gameStart(carNames, tryCount);

        OutputView outputView = new OutputView();
        outputView.printGameResult(resultList, new Referee());
    }

    public StringBuilder getWinner(List<Car> carNameList, Referee referee) {
        StringBuilder gameResult = getInstance().getGameResult();

        for (int k = 0; k < carNameList.size(); k++) {
            Car car = carNameList.get(k);
            referee.startEngine(car);
            gameResult.append(car).append('\n');
        }

        gameResult.append('\n');
        return gameResult;
    }
}
