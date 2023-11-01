package racingcar.domain.winner;

import java.util.List;

public class Winners {
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String COMMA = ", ";

    private final List<String> winners;

    public Winners(List<String> winners) {
        this.winners = winners;
    }

    public String getWinnersMessage() {
        return WINNER_MESSAGE + String.join(COMMA, winners);
    }
}
