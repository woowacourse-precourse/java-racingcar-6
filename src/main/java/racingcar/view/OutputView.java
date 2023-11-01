package racingcar.view;

import java.util.List;
import racingcar.domain.car.CarDto;

public interface OutputView {
    void printRequestCarNames();
    void printRequestGameRound();
    void printResultMessage();
    void printRoundResult(List<CarDto> result);
    void printGameWinner(String winners);
}
