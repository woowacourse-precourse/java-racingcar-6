package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String DISPLAY_NAME_FORMAT = "%s : %s";
    private static final String DISPLAY_WINNER_FORMAT = "최종 우승자 : %s";

    // 경주의 진행 상황을 출력
    public static void displayRoundProgress(List<Car> cars) {
        for (Car car : cars) {
            displayCarPosition(car);
        }
        System.out.println();
    }

    private static void displayCarPosition(Car car) {
        StringBuilder displayPosition = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            displayPosition.append("-");
        }
        System.out.printf((DISPLAY_NAME_FORMAT) + "%n", car.getName(), displayPosition);
    }

    public static void displayWinners(List<String> winnerNames) {
        String joinedWinners = String.join(", ", winnerNames);
        System.out.printf(DISPLAY_WINNER_FORMAT, joinedWinners);
    }
}
