package racingcar.view.output;

import racingcar.dto.GameResult;

import java.util.List;

public interface OutputView {
    void printInputCarNamesMessage();
    void printInputRetryCountMessage();
    void printTotalGameResults(List<List<GameResult>> totalGameResult);
    void printWinners(List<String> winners);
}
