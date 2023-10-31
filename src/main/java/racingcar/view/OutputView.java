package racingcar.view;

import java.util.List;
import java.util.Map;

public interface OutputView {
    void displayCarNameInputNotice();
    void displayMoveCountInputNotice();
    void displayRaceStatus(List<Map<String, Integer>> result);
    void displayWinners(List<String> winners);
}
