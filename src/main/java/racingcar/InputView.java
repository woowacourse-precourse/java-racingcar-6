package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    GameException gameException = new GameException();

    public String[] inputPlayerCarName() {
        String carName = Console.readLine();
        String[] carNames = carName.split(",");
        checkCarNamesLoop(carNames);

        return carNames;
    }

    public int inputPlayerTryNumber() {
        String tryNumber = Console.readLine();
        checkTryNumberException(tryNumber);

        return Integer.parseInt(tryNumber);
    }

    private void checkCarNamesLoop(String[] carNames) {
        for (String carName : carNames) {
            checkCarNameException(carName);
        }
    }

    private void checkCarNameException(String carName) {
        gameException.validatePlayerCarNameLengthRange(carName);
        gameException.validatePlayerCarNameBlank(carName);
        gameException.validatePlayerCarNameType(carName);
        gameException.validatePlayerCarNameOnlyLowerCase(carName);
    }

    private void checkTryNumberException(String tryNumber) {
        gameException.validatePlayerTryNumberType(tryNumber);
    }
}
