package racingcar.view;

import java.util.List;

public interface View {
    List<String> inputNames();

    int inputCountNumber();

    void printResultStart();

    void printProgressResult(String result);

    void printChampions(String champions);
}
