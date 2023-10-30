package racingcar.view.output;

import racingcar.model.dto.CarResponse;
import racingcar.model.dto.WinnerResponse;
import java.util.List;

public interface Outputview {

    void askCarNames();
    void askPlayCount();
    void printResult();
    void printEachCarStatus(final List<CarResponse> cars);
    void printBlankLine();
    void printWinners(final List<WinnerResponse> winners);
}
