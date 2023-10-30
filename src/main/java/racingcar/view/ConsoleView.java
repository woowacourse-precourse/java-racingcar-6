package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

public class ConsoleView implements GameView {
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String DASH = "-";

    public ConsoleView() {
    }

    @Override
    public String getUserInput() {
        return Console.readLine();
    }

    @Override
    public void printInputCars() {
        System.out.println(ViewConstants.INPUT_CARS);
    }

    @Override
    public void printInputMoveCount() {
        System.out.println(ViewConstants.INPUT_MOVE_COUNT);
    }

    @Override
    public void printExecutionStart() {
        System.out.println(ViewConstants.OUTPUT_EXECUTION_START);
    }

    @Override
    public void printMoveResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(String.format(
                    ViewConstants.OUTPUT_CAR_STATUS_FORMAT.toString(),
                    car.getName(),
                    DASH.repeat(car.getDistance()))
            );
        });
        System.out.println();
    }

    @Override
    public void printFinalWinner(List<String> winners) {
        String result = String.join(WINNER_NAME_DELIMITER, winners);
        System.out.print(ViewConstants.OUTPUT_FINAL_WINNER + result);
    }
}
