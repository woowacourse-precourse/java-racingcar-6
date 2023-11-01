package racingcar.module.view;

import static racingcar.global.constant.Game.MOVE;
import static racingcar.global.constant.GameMessage.ENTER_CAR_NAMES;
import static racingcar.global.constant.GameMessage.ENTER_TRIAL_NUMBER;
import static racingcar.global.constant.GameMessage.RESULT_CAR_NAME;
import static racingcar.global.constant.GameMessage.RESULT_INFO_MESSAGE;
import static racingcar.global.constant.GameMessage.WINNER_INFO;

import java.util.List;
import racingcar.module.domain.Car;

public class Output {

    private static final String JOINER = ",";

    public static void printEnterCarNamesMessage() {
        System.out.println(ENTER_CAR_NAMES);
    }

    public static void printEnterTrialMessage() {
        System.out.println(ENTER_TRIAL_NUMBER);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_INFO_MESSAGE);
    }

    public static void printScore(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(String.format(RESULT_CAR_NAME, car.getName()));
            printMovingNumber(car.getMoving());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String result = String.join(JOINER, winners);
        System.out.println(String.format(WINNER_INFO, result));
    }

    private static void printMovingNumber(int moving) {
        for (int i = 0; i < moving; i++) {
            System.out.print(MOVE);
        }
        System.out.println();
    }
}
