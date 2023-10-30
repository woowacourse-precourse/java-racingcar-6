package racingcar.view;

import static racingcar.gameutil.GameMessage.*;

import java.util.Collection;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.gameutil.GameMessage;

public class OutputView {

    public void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MSG.getMsg());
    }

    public void printMoveResult(Cars cars) {
        Collection<Car> carList = cars.getCars();

        for (Car car : carList) {
            System.out.println(moveResult(car));
        }

        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.print(WINNER_MSG.getMsg());
        System.out.println(winners(winners));
    }
}
