package racingcar.view.output;

import java.util.List;

public interface OutputView {

    void askCarNames();
    void askPlayCount();
    void printGameEnd();
    void printCarsStatus(List<String> cars);
    void printWinners(List<String> winners);
}
