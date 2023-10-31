package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import racingcar.Global.Constants;
import racingcar.Model.Car;
import racingcar.Model.Game;
import racingcar.Model.RandomNumberGenerator;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Controller {
    private InputView inputView;
    private OutputView outputView;
    private Game game;

    public Controller(InputView inputView, OutputView outputView) {
        init(inputView, outputView);
    }

    private void init(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        game = new Game(makeNewCars(), new RandomNumberGenerator(), getGameStageNumber());
    }

    private List<String> getCarName() {
        outputView.printString(Constants.getCarsNameState);
        return inputView.getCarsName();
    }

    private List<Car> makeNewCars() {
        List<Car> result = new ArrayList<>();
        for (String carName : getCarName()) {
            result.add(new Car(carName));
        }
        return result;
    }

    private int getGameStageNumber() {
        outputView.printString(Constants.getGameStageNumberState);
        return inputView.getStageNumber();
    }

    public void run() {
        outputView.printString(Constants.gameResultStartingState);
        while (!game.isGameEnd()) {
            Map<String, Integer> result = game.runStage();
            outputView.printEachStageResult(result);
        }
        outputView.printWinner(game.findWinner());
    }

}
