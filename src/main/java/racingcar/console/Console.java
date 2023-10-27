package racingcar.console;

import java.util.List;

public interface Console {
    void displayAskForUserCarNameMessage();
    String getPlayerCarName();
    void displayAskForCount();
    String getCount();
    void displayResultText();
    void displayResult(String carName, int distance);
    void displayWinner(List<String> winners);
}
