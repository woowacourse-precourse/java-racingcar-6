package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public interface OutputView {
    void printRequestCarNames();
    void printRequestGameRound();
    void printResultMessage();
    void printRoundResult(List<CarDto> result);
    void printGameWinner();
}
