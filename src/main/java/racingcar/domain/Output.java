package racingcar.domain;

public interface Output {
    void printCarNamesInputRequest();
    void printMoveCountInputRequest();
    void addCarState(String name, int path);
    void printCarsState();
    void printResultStartedMessage();
}
