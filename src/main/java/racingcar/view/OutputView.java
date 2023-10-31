package racingcar.view;

import java.util.List;
import racingcar.constants.MessageConstants;

public class OutputView {

    public static void printCarMovingStatus(List<String> carStatuses) {
        for (String carStatus : carStatuses) {
            System.out.println(carStatus);
        }
        System.out.println();
    }

    public static void printFinalWinners(List<String> winners) {
        System.out.println(MessageConstants.FINAL_WINNERS + String.join(", ", winners));
    }
}