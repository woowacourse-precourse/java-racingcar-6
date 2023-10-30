package racingcar.view.output;

import racingcar.model.dto.CarResponse;
import java.util.List;

public interface OutputView {

    void askCarNames();
    void askPlayCount();
    void printResult();
    void printEachCarStatus(final List<CarResponse> cars);
    void printBlankLine();
    void printWinners(final List<CarResponse> winners);
}
