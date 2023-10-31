package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.dto.request.CarNames;
import racingcar.dto.request.TryCount;

public class InputView {

    private static final String CAR_NAME_SEPARATOR = ",";

    public CarNames readCarNames() {
        return CarNames.from(List.of(getInput().split(CAR_NAME_SEPARATOR)));
    }

    public TryCount readTryCount() {
        return TryCount.fromInput(getInput());
    }

    private String getInput() {
        return Console.readLine();
    }
}
