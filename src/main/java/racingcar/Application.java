package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.Winner;
import racingcar.domain.car;
import racingcar.domain.cars;
import racingcar.io.InputView;
import racingcar.io.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);


        cars cars = new cars(InputView.readCarNames());
        Racing racing = new Racing(inputView.readMoveTurnCount());

        outputView.print("\n실행 결과");
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
