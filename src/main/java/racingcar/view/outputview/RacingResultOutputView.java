package racingcar.view.outputview;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.controller.RegisterCarNamesController;
import racingcar.model.Car;
import racingcar.model.RacingCars;

public class RacingResultOutputView implements OutputView {
    private static final String JOIN_COMMA = ", ";
    private static final String FINAL_RESULT_FORMAT = "%s : %s\n";
    private static final String FINAL_RESULT_PREFIX = "최종 우승자";

    @Override
    public void print(Map<String, Object> model) {
        RacingCars racingCars = (RacingCars) model.get(RegisterCarNamesController.RACING_CARS_KEY);
        showWinners(racingCars);
    }

    private void showWinners(RacingCars racingCars) {
        List<String> winnerNames = racingCars.findWinner()
                .stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());

        String winnerNamesWithComma = String.join(JOIN_COMMA, winnerNames);
        System.out.printf(FINAL_RESULT_FORMAT, FINAL_RESULT_PREFIX, winnerNamesWithComma);
    }
}
