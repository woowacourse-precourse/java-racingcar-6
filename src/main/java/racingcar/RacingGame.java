package racingcar;


import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final RacingList racingList = new RacingList();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Integer count;

    public void run() {
        createCarList();
        count = inputView.inputCount();
        gameStart(racingList, count);
        outputView.printResult(racingList.returnWinners());
    }

    private void createCarList() {
        String cars = inputView.inputCarList();
        racingList.createData(cars);
    }

    public void gameStart(RacingList racingList, Integer count) {
        for (int i = 0; i < count; i++) {
            racingList.updateState();
            outputView.printState(racingList);
        }
    }

}
