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

    public Integer getNumberOfRound() {
        String numberOfRoundString = readLine();
        for (int i = 0; i < numberOfRoundString.length(); ++i) {
            char ch = numberOfRoundString.charAt(i);
            if (ch < '0' || ch > '9') {
                throw new IllegalArgumentException();
            }
        }
        return Integer.valueOf(numberOfRoundString);
    }
}
