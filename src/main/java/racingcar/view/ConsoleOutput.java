package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

import static racingcar.view.constants.IOType.*;

public class ConsoleOutput {

    public static void alertExecutionResultPrint() {
        System.out.println(ALERT_EXECUTION_RESULT_SENTENCE.getText());
    }

    public static void executionResultPrint(List<Car> carList) {
        carList.stream().forEach(car -> {
            String carName = car.getName();
            int carDistance = car.getDistance();
            String distancePole = getDistancePole(carDistance);
            System.out.printf("%s : %s\n", carName, distancePole);
        });
        System.out.println();
    }

    private static String getDistancePole(int carDistance) {
        String distancePole = "";
        for (int i = 0; i < carDistance; i++) {
            distancePole += DISTANCE_POLE_CHAR.getText();
        }
        return distancePole;
    }

    public static void winnersPrint(List<Car> winnerList) {
        String winnerString = "";
        for(Car winner : winnerList) {
            winnerString += winner.getName() + WINNER_DELIMITER.getText();
        }
        String trimWinnerString = trimString(winnerString);
        System.out.printf("최종 우승자 : %s", trimWinnerString);
    }

    private static String trimString(String sentence) {
        return sentence.substring(0, sentence.length() - 2);
    }
}
