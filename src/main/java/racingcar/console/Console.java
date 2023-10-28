package racingcar.console;

import racingcar.domain.participant.Participant;

import java.util.List;

public interface Console {
    String getPlayerNames();
    String getRaceCount();
    void displayResultText();
    void displayState(String Name, int distance);
    void displayWinner(List<Participant> winners);
}
