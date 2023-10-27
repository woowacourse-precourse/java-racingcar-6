package racingcar.domain;

import java.util.List;

public class WinnersMessage {

    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private final String message;

    public WinnersMessage(List<Car> winners) {
        List<String> names = getNames(winners);
        message = FINAL_WINNER_MESSAGE + String.join(", ", names);
    }

    private static List<String> getNames(List<Car> winners) {
        return winners.stream().map(Car::getName).toList();
    }

    @Override
    public String toString() {
        return message;
    }

}
