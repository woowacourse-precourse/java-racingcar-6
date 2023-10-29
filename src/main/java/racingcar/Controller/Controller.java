package racingcar.Controller;

import java.util.List;
import java.util.Map;
import racingcar.Model.Game;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Controller {
    private InputView inputView;
    private OutputView outputView;
    private Game game;

    public void init() {
        outputView.printString();
        List<String> carNames = splitString(inputView.getCarsName());
        outputView.printString();
        int stageNumber = StringToInt(inputView.getStageNumber());
        game = new Game(carNames, stageNumber);
    }

    public void run() {
        outputView.printString();
        while (!game.isGameEnd()) {
            Map<String, Integer> result = game.runStage();
            outputView.printEachStageResult(result);
        }
        outputView.printWinner(game.findWinner());
    }

    public int StringToInt(String string) {

    }

    public List<String> splitString(String string) {

    }
}
