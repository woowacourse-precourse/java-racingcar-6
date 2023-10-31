package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.dto.CarNames;

public class InputView {

    private static final String CAR_NAME_SEPARATOR = ",";

    public CarNames readCarNames() {
        return CarNames.from(List.of(getInput().split(CAR_NAME_SEPARATOR)));
    }

    private String getInput() {
        return Console.readLine();
    }
}
