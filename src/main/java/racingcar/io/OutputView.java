package racingcar.io;

import java.util.List;
import racingcar.GameMessage;
import racingcar.RacingCar;

public class OutputView {

    private OutputView() {
    }

    private static final String CAR_LOCATION_POINTER = "-";
    private static final String WINNER_SEPERATOR = ",";

    public static void printRequestCarNames() {
        System.out.println(GameMessage.INPUT_CAR_NAMES.getMessage());
    }

    public static void printRequestTryCount() {
        System.out.println(GameMessage.INPUT_TRY_COUNT.getMessage());
    }

    public static void printCarLocation(RacingCar racingCar) {
        System.out.println(racingCar.getName() + " : " + CAR_LOCATION_POINTER.repeat(racingCar.getLocation()));
    }

    public static void printResultMessage(List<RacingCar> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(winners.get(0));

        for (int i = 1; i < winners.size(); i++) {
            sb.append(WINNER_SEPERATOR).append(winners.get(i));
        }

        System.out.println(GameMessage.FINAL_WINNER+sb.toString());
    }


}
