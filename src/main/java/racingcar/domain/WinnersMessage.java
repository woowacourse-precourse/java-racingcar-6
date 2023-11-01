package racingcar.domain;

import java.util.List;

public class WinnersMessage {

    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private final String message;

    public WinnersMessage(List<String> winners) {
        message = FINAL_WINNER_MESSAGE + String.join(", ", winners);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof WinnersMessage winnersMessage) {
            return message.equals(winnersMessage.message);
        }
        return false;
    }

}
