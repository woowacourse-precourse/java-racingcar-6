package racingcar.Controller;

import racingcar.Domain.Car;
import racingcar.Service.RacingGame;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import java.util.List;

public class GameController {

    private RacingGame game;
    private InputView inputView;
    private OutputView outputView;
    private Integer tryCount;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void playGame() {
        String carsName = inputView.getCarsName();
        this.tryCount = inputView.getTryCount();
        this.game = new RacingGame(carsName);

        outputView.printRESULT_GUIDE();
        while (tryCount > 0) {
            tryCount--;
            List<Car> racingResult= game.racing();
            outputView.printRacingResult(racingResult);
        }

        List<String> winners = game.findWinners();
        outputView.printWinners(winners);
    }
}
