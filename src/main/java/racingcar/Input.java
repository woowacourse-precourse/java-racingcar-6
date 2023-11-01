package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    static String[] getCarName() {
        String carNameInput = InputUtils.readCarNameInput();
        carNameInput = carNameInput.replaceAll("^,+|,+$", "").replaceAll(",+", ",");
        InputUtils.checkEmptyOrBlankCarNames(carNameInput);
        String[] carNames = InputUtils.splitCarNameInput(carNameInput);
        InputUtils.checkDuplicateCarNames(carNames);
        return (carNames);
        }

    static int getTryNumber() {
        String tryNumberInput = Console.readLine();
        InputUtils.checkTryNumberInputLength(tryNumberInput);
        long tryNumber = 0;
        try {
            tryNumber = Long.parseLong(tryNumberInput);
            InputUtils.checkTryNumberRange(tryNumber);
        } catch (NumberFormatException numberFormatException) {
            Exception.generateInvalidNumberCharacterException();
        }
        return ((int) tryNumber);
    }
}
