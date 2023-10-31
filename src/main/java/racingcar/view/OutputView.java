package racingcar.view;

import java.util.List;
import racingcar.service.CarDto;

public class OutputView {
    private final static String MOVEMENT = "-";

    public void raceResultMessage() {
        System.out.println("\n" + OutputMessage.RACE_RESULT.getMessage());
    }

    public void raceResultByOrderMessage(final List<CarDto> cars) {
        for (CarDto car : cars) {
            System.out.println(car.getName() + " : " + MOVEMENT.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void raceWinnerMessage(final List<String> cars) {
        System.out.println(OutputMessage.WINNER_IS.getMessage() + String.join(", ", cars));
    }
}
