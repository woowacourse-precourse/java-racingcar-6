package racingcar;

public class Validation {

    private boolean isValid = true;

    public boolean validateInput(int whichInput, String input) {
        if (whichInput == Constant.CARSVALIDATE) {
            isValid = validateIsNotNull(input) & validateCanSplitAndNotLong(input);
        } else if (whichInput == Constant.TIMEVALIDATE) {
            isValid = validateIsNotNull(input) & validateIsNumber(input);
        }
        return isValid;

    }

    private boolean validateIsNotNull(String input) {
        if (input == "") {
            return false;
        }
        return true;
    }

    private boolean validateCanSplitAndNotLong(String input) {
        String[] carArray = input.split(",");
        if (!validateCarName(carArray)) {
            return false;
        }
        return true;
    }

    private boolean validateCarName(String[] carArray) {
        for (String carName : carArray) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }

    private boolean validateIsNumber(String input) {
        return input.matches("\\d+");
    }

}
