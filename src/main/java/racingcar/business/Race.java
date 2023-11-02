package racingcar.business;

import racingcar.ui.InputView;
import racingcar.ui.Output;
import racingcar.ui.OutputView;

import java.util.List;

public class Race {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    CarManager carManager;

    public Race() {
        NumberMaker numberMaker = new RandomNumberMaker();
        carManager = new CarManager(numberMaker);
    }

    public void doRacing() {

        List<String> names = getNames();

        Integer gameCount = getGameCount();

        carManager.generateCarList(names);

        for (int i = 0; i < gameCount; i++) {
            List<Car> matchResult = carManager.runMatch();
            printMatchResult(matchResult);

            outputView.print(Output.BLANK_LINE);
        }

        printWinners();

        inputView.close();
    }

    private void printWinners() {
        List<String> winnerNames = carManager.getWinnerNames();
        String result = String.join(", ", winnerNames);
        outputView.printWinnerNames(result);
    }

    private Integer getGameCount() {
        outputView.print(Output.GET_GAME_COUNT);
        Integer gameCount = inputView.getGameCount();
        return gameCount;
    }

    private List<String> getNames() {
        outputView.print(Output.GET_NAMES);
        List<String> names = inputView.getNames();
        return names;
    }

    private void printMatchResult(List<Car> matchResult) {
        for (Car car : matchResult) {
            outputView.printMoveResult(car);
        }
    }

}
