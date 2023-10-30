package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private static final String GAME_RESULT_TITLE = "\n실행 결과";
    private static final String GAME_WINNER_FORMAT = "최종 우승자 : %s\n";
    private static final String ONE_STEP = "-";
    private static final String GAME_STATUS_FORMAT = "%s : %s\n";
    private static final String JOIN_PARAMETER = ", ";

    public void printResultTitle() {
        System.out.println(GAME_RESULT_TITLE);
    }

    public void printStatus(List<Car> cars) {
        for (Car car : cars) {
            String steps = ONE_STEP.repeat(car.getStep());
            System.out.printf(GAME_STATUS_FORMAT, car.getName(), steps);
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.printf(GAME_WINNER_FORMAT, String.join(JOIN_PARAMETER, winners));
    }

}
