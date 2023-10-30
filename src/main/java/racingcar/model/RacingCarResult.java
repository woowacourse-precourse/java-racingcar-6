package racingcar.model;

import java.util.List;

public class RacingCarResult {

    public static final String ONE_STEP = "-";
    public static final String COLON = ":";
    private static final String FINAL_WINNER = "최종 우승자";

    public static String carMovementResult(Car car) {
        String movementDistance = carMovement(car);
        return String.join(" ", car.toString(), COLON, movementDistance);
    }

    public static String winnersResult(List<Car> winners) {
        String winnersString = convertWinnersToString(winners);
        return String.join(" ", FINAL_WINNER, COLON, winnersString);
    }

    private static String carMovement(Car car) {
        return ONE_STEP.repeat(car.getTravelDistance());
    }

    private static String convertWinnersToString(List<Car> winners) {
        return String.join(",", winners.toString().replace("[", "").replace("]", ""));
    }
}
