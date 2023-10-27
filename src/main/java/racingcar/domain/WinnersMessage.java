package racingcar.domain;

import java.util.List;

public class WinnersMessage {

    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private final String message;

    public WinnersMessage(List<Car> winners) {
        message = FINAL_WINNER_MESSAGE + String.join(", ");
    }

    @Override
    public String toString() {
        return message;
    }

}
