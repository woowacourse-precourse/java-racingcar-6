package racingcar.Controller;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void init(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        game = new Game(makeNewCars(), new RandomNumberGenerator(), getGameStageNumber());
    }

    public List<String> getCarName() {
        outputView.printString(Constants.getCarsNameState);
        return splitString(inputView.getCarsName());
    }

    public List<Car> makeNewCars() {
        List<Car> result = new ArrayList<>();
        for (String carName : getCarName()) {
            result.add(new Car(carName));
        }
        return result;
    }

    public int getGameStageNumber() {
        outputView.printString(Constants.getGameStageNumberState);
        return StringToInt(inputView.getStageNumber());
    }

    public void run() {
        outputView.printString(Constants.gameResultStartingState);
        while (!game.isGameEnd()) {
            Map<String, Integer> result = game.runStage();
            outputView.printEachStageResult(result);
        }
        outputView.printWinner(game.findWinner());
    }

    public Boolean isStringNumber(String string) {
        return string.matches("\\d+");
    }

    public int StringToInt(String string) {
        if (!isStringNumber(string)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(string);
    }

    public Boolean isStringSplitBySymbol(String string, String symbol) {
        return string.split(symbol).length >= 2;
    }

    public List<String> splitString(String string) {
        if (!isStringSplitBySymbol(string, Constants.splitSymbol)) {
            throw new IllegalArgumentException();
        }
        List<String> result = Arrays.asList(string.split(Constants.splitSymbol));
        return result;
    }
}
