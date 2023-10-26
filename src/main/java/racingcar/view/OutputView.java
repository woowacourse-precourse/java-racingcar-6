package racingcar.view;

import racingcar.controller.dto.GameResultResponse;
import racingcar.controller.dto.GameWinnerResponse;

public interface OutputView {

    void printCarNameRequestMessage();
    void printGameAttemptsNumberRequestMessage();
    void printGameResultMessage();
    void printGameResult(GameResultResponse gameResultResponse);
    void printWinner(GameWinnerResponse gameWinnerResponse);
}
