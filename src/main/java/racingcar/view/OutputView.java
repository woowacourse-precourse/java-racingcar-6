package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

import java.util.List;

public class OutputView {
    private static final String ENTER_REGEX = "\n";
    private static final String COLON_REGEX = " : ";
    private static final String DASH_REGEX = "-";
    private static final String COMMA_REGEX = ", ";
    private static final String ROUND_MSG = "실행 결과";
    private static final String WINNER_MSG = "최종 우승자";

    private static OutputView instance;

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printRoundResult(RacingCars racingCars) {
        StringBuilder result = new StringBuilder();
        result.append(ENTER_REGEX)
                .append(ROUND_MSG)
                .append(ENTER_REGEX);
        for (RacingCar car : racingCars.getRacingCars()) {
            result.append(car.getName())
                    .append(COLON_REGEX)
                    .append(DASH_REGEX.repeat(car.getDistance()))
                    .append(ENTER_REGEX);
        }
        System.out.print(result);
    }

    public void printWinnerResult(List<RacingCar> winners) {
        StringBuilder result = new StringBuilder();
        result.append(ENTER_REGEX)
                .append(WINNER_MSG)
                .append(COLON_REGEX);
        for (RacingCar car : winners){
            result.append(car.getName())
                    .append(COMMA_REGEX);
        }
        result.replace(result.length() - 2, result.length(), "");
        System.out.println(result);
    }
}
