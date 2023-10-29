package racingcar.view;

import java.util.List;
import racingcar.model.RacingCar;

public class OutputView {
    private static final String SEPARATE_CHAR = ",";
    private static final String SEPARATE_COLON = " : ";

    public static void gameResultMessge() {
        System.out.println("실행 결과");
    }

    public static void moveDistanceMessage(RacingCar racingCar) {
        System.out.println(racingCar.getName() + SEPARATE_COLON + racingCar.getDistanceAsBar());
    }

    public static void printFinalWinner(List<String> winners) {
        String result = String.join(SEPARATE_CHAR, winners);
        System.out.println("최종 우승자" + SEPARATE_COLON + result);
    }

    public static void newLine() {
        System.out.println();
    }
}
