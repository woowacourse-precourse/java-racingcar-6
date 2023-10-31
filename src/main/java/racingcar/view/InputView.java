package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        String carNameString = readLine();
        carNames = List.of(carNameString.split(","));
        if (carNames.size() == 0) {
            throw new IllegalArgumentException();
        }

        return carNames;
    }
}
