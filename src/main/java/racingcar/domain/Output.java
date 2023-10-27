package racingcar.domain;

import java.util.List;

public interface Output {
    void printCarNamesInputRequest();
    void printMoveCountInputRequest();
    void addCarState(String name, int path);
    void printCarsState();
    void printResultStartedMessage();
    void printWinner(List<String> winnerNameList);
}
