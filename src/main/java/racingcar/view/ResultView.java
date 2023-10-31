package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.vo.Car;

public class ResultView {

    private static final String RACING_RESULT = "실행결과";
    private static final String RACING_RESULT_WINNERS = "최종 우승자 : ";
    private static final String CAR_POSITION_DISPLAY = "-";
    private static final String USER_INPUT_SEPARATOR = ",";
    private static final String CAR_NAME_BORDER = " : ";
    private static final String LINE_BREAK = "";

    public ResultView() {
        System.out.println(RACING_RESULT);
    }

    public void RacingResult(Map<Car, List<Integer>> positionHistory, int attempt) {
        for (int i = 0; i < attempt; i++) {
            int index = i;
            positionHistory.forEach((k, v) -> showRacingResult(k, v.get(index)));
            System.out.println(LINE_BREAK);
        }
    }

    private void showRacingResult(Car car, int position) {
        System.out.print(car.getName() + CAR_NAME_BORDER);
        for (int i = 0; i < position; i++) {
            System.out.print(CAR_POSITION_DISPLAY);
        }
        System.out.println(LINE_BREAK);
    }

    public void showRacingWinners(List<String> winners) {
        String names = String.join(USER_INPUT_SEPARATOR, winners);
        System.out.println(RACING_RESULT_WINNERS + names);
    }

}
