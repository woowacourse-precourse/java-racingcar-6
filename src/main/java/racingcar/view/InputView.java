package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public List<String> getCarNames() {
        try {
            String carNamesRawData = Console.readLine();

            validateNull(carNamesRawData);

            String[] splitCarNamesByComma = carNamesRawData.split(",");
            List<String> carNames = new ArrayList<>();
            for (int idx = 0; idx < splitCarNamesByComma.length; idx++) {
                validateCarNameLength(splitCarNamesByComma[idx]);
                carNames.add(splitCarNamesByComma[idx]);
            }
            return carNames;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNull(String data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
