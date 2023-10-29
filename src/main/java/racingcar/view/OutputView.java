package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private static final String DISTANCE = "-";
    private static final String COLON = " : ";
    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자";

    public void printGameResultStatement() {
        System.out.println(GAME_RESULT);
    }

    public void printResult(Car car) {
        printCarNames(car.getName());
        printDistance(car.getDistance());
    }

    public void printCarNames(String carName) {
        System.out.print(carName + COLON);
    }

    public void printDistance(int distance) {
        System.out.println(DISTANCE.repeat(distance));
    }

    public void printWinners(List<String> racingWinners) {
        System.out.print(WINNER + COLON);
        System.out.print(String.join(",", racingWinners));
    }

}
