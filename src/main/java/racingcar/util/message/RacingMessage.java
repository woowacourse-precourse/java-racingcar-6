package racingcar.util.message;

import java.util.List;
import racingcar.domain.Car;

public enum RacingMessage {

    TRIAL_INFO_MESSAGE("%s : %s"),
    RESULT_WINNER_MESSAGE("최종 우승자 : %s\n");

    private final String racingMessage;

    RacingMessage(String racingMessage) {
        this.racingMessage = racingMessage;
    }

    public String getRacingTrialMessage() {
        return racingMessage;
    }

    public String getRacingWinnerMessage(List<Car> winner) {
        String winnerString = String.join(", ", winner.stream().map(Car::getName).toList());
        return String.format(racingMessage, winnerString);
    }

}
