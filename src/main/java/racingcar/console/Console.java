package racingcar.console;

import racingcar.domain.participant.Participant;

import java.util.List;

public interface Console {
    String getPlayerCarNames();
    String getRaceCount();
    void displayResultText();
    void displayState(String carName, int distance);
    void displayWinner(List<Participant> winners);
}
