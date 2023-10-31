package racingcar.view;

import static racingcar.constant.RacingSign.CAR_NAME_SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.dto.request.CarNames;
import racingcar.dto.request.TryCount;

public class InputView {

    public CarNames readCarNames() {
        return CarNames.from(List.of(getInput().split(CAR_NAME_SEPARATOR.toString())));
    }

    public TryCount readTryCount() {
        return TryCount.fromInput(getInput());
    }

    private String getInput() {
        return Console.readLine();
    }
}
