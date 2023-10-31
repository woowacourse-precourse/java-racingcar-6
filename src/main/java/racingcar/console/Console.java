package racingcar.console;

import java.util.List;

public interface Console {
    String getPlayerNames();
    String getRaceCount();
    void displayResultText();
    void displayStatus(String Name, int distance);
    void displayWinners(List<String> winners);
}
