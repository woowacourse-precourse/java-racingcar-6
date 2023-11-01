package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.Winner;
import racingcar.domain.car;
import racingcar.domain.cars;
import racingcar.io.InputView;
import racingcar.io.OutputView;

import java.util.List;

import static racingcar.constant.Message.RESULT_MESSAGE;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);


        cars cars = new cars(InputView.readCarNames());
        Racing racing = new Racing(inputView.readMoveTurnCount());

        outputView.print(RESULT_MESSAGE);
        List<car> moveResult;
        for (int i = 0; i < Racing.getCount(); i++) {
            moveResult = cars.tryToMove();
            for (car car : moveResult) {
                outputView.printCarPosition(car.getName(), car.getPosition());
            }
            outputView.printEnter();
        }
        Winner winner = new Winner();
        List<String> winners = winner.judgeWinner(cars.getCurrentStatus());
        outputView.printWinners(winners);
    }
}
