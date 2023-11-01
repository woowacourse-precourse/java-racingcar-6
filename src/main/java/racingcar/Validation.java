package racingcar;

public class Validation {

    private boolean isValid = true;

    public boolean validateInput(int whichInput, String input) {
        if (whichInput == Constant.CARS_VALIDATE) {
            isValid = validateIsNotNull(input) & validateCanSplitAndNotLong(input);
        } else if (whichInput == Constant.TIME_VALIDATE) {
            isValid = validateIsNotNull(input) & validateIsNumber(input);
        }
        return isValid;

    }

    private boolean validateIsNotNull(String input) {
        return input != "";
    }

    private boolean validateCanSplitAndNotLong(String input) {
        String[] carArray = input.split(",");
        return validateCarName(carArray);
    }

    private boolean validateCarName(String[] carArray) {
        for (String carName : carArray) {
            if (carName.length() > Constant.CAR_NAME_LIMIT) {
                return false;
            }
        }
        return true;
    }

    private boolean validateIsNumber(String input) {
        return input.matches("\\d+");
    }

}
