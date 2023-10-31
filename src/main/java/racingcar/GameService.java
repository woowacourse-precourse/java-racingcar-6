package racingcar;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class GameService {
    public Cars getCars() {
        List<String> names = InputView.getNames();
        return Cars.of(names);
    }

    public int getTrialCount() {
        return InputView.getTrialCount();
    }
}
