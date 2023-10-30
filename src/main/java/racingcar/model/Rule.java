package racingcar.model;

import java.util.List;

public interface Rule {
    List<String> getCarNames();
    Integer getNumberOfRounds();
    void printCurrentPerformance();
    void printBestPerformers();
}
