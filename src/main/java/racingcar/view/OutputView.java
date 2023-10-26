package racingcar.view;

import java.util.List;
import racingcar.controller.dto.GameResultResponse;

public interface OutputView {

    void printCarNameRequestMessage();

    void printGameAttemptsNumberRequestMessage();

    void printGameResultMessage();

    void printGameResult(GameResultResponse gameResultResponse);

    void printWinner(List<String> winners);
}
