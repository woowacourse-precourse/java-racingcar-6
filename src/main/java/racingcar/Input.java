package racingcar;

public class Input {

    static String[] getCarName() {
        String carNameInput = InputUtils.readUserInput();
        carNameInput = carNameInput.replaceAll("^,+|,+$", "").replaceAll(",+", ",");
        InputUtils.checkEmptyOrBlankCarNames(carNameInput);
        String[] carNames = InputUtils.splitCarNameInput(carNameInput);
        InputUtils.checkDuplicateCarNames(carNames);
        return (carNames);
        }

    static int getTryNumber() {
        String tryNumberInput = null;
        tryNumberInput = InputUtils.readUserInput();
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
