package racingcar.view;

import java.util.Map;
import racingcar.domain.Car;
import racingcar.util.Constants;

public class OutputView {
    public void printGameResult() {
        System.out.println("\n" + Constants.GAME_RESULT_MESSAGE);
    }

    public void printMoveResult(Map<Car, Integer> moveResults) {
        for (Car car : moveResults.keySet()) {
            String position = converterPosition(car.getPosition());
            System.out.printf("%s : %s\n", car.getName(), position);
        }
        System.out.println();
    }

    private String converterPosition(final int position) {
        return "-".repeat(position);
    }
}
