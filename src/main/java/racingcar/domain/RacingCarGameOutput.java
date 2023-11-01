package racingcar.domain;

import static racingcar.message.AlarmMessage.RESULT_HEADER_MESSAGE;

import java.util.List;
import racingcar.dto.RacingCar;

public class RacingCarGameOutput {
    public static void printGameProgress(List<RacingCar> carList) {
        StringBuilder sb = new StringBuilder();
        for (RacingCar car : carList) {
            sb.append(car.getName()).append(" : ");
            sb.append("-".repeat(car.getDistance())).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void printWinnersMessage(List<RacingCar> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(RESULT_HEADER_MESSAGE.getMessage());

        List<String> winnerNames = winners.stream().map(RacingCar::getName).toList();
        String winnersString = String.join(", ", winnerNames);
        sb.append(winnersString);

        System.out.println(sb.toString());
    }
}
