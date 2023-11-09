package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutPutView;

import java.util.stream.IntStream;

public class CarGameManager {

    public Cars carNamesSet() {
        return Cars.createCars(InputView.startInputView());
    }

    public int roundNumberSet() {
        return InputView.roundNumberInputView();
    }

    public void carGameStart(Cars cars, final int roundNumber) {
        OutPutView.executionResultView();
        IntStream.range(0, roundNumber).forEach(i -> {
            cars.carsMove();
            OutPutView.resultNameAndAdvanceView(cars.carsResult());
        });
    }

    public void resultWinner(Cars cars) {
        OutPutView.resultWinnerView(cars.getWinnerNames());
    }
}
