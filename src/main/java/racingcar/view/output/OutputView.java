package racingcar.view.output;

import static racingcar.constant.PrintOutMessage.EXECUTE_GAME;
import static racingcar.constant.PrintOutMessage.PLZ_INPUT_CAR_NAME;
import static racingcar.constant.PrintOutMessage.PLZ_INPUT_TRY_COUNT;
import static racingcar.constant.PrintOutMessage.WINNER_NAME;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void printOutCarName() {
        System.out.println(PLZ_INPUT_CAR_NAME.message);
    }

    public void printOutTryCount() {
        System.out.println(PLZ_INPUT_TRY_COUNT.message);
    }

    public void printOutExecuteGame() {
        System.out.println(EXECUTE_GAME.message);
    }

    public void printGameStep(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.showPosition().toString());
        }
        System.out.println();
    }

    public void printOutWinner(List<String> winners) {
        System.out.print(WINNER_NAME.message);
        String winner = String.join(",", winners);
        System.out.print(winner);
    }
}
