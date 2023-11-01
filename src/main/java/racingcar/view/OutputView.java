package racingcar.view;

import java.util.List;
import racingcar.RacingCar;

public class OutputView {
    private static final String COLON = " : ";
    private static final String DELIMITER = ",";
    private static final String DISTANCE = "-";

    public void printResult(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            System.out.println(formatCarInformation(car));
        }
        System.out.println();
    }

    private String formatCarInformation(RacingCar car) {
        return car.getName() + COLON + formatDistance(car.getDistance());
    }

    private String formatDistance(int distance) {
        String dash = "";
        while (distance > 0) {
            dash += DISTANCE;
            distance--;
        }
        return dash;
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자" + COLON + formatWinners(winners));
    }


    private String formatWinners(List<String> winners) {
        return String.join(DELIMITER + " ", winners);
    }
}
