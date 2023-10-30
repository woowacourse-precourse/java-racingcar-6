package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarsName() {
        String carsName = Console.readLine();
        validateBlankCarsName(carsName);
        return carsName;
    }

    private void validateBlankCarsName(String carsName) {
        if (carsName.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
