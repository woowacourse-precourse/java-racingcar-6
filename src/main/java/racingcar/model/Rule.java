package racingcar.model;

import java.util.List;

public interface Rule {
    public List<String> getCarNames();
    public Integer getNumberOfRounds();
    public void printCurrentPerformance();
    public void printBestPerformers();
}
