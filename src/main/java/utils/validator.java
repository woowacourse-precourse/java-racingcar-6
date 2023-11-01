package utils;

public class validator {
    public static boolean isCarNameValid(String carNameInput) {
        String [] carNames = carNameInput.split(",");

        for (String carName : carNames) {
            if (carName.trim().length() > 5) {
               return false;
            }
        }
        return true;
    }

    public static boolean isTryCountNumberValid(String tryCountInput) {
        return tryCountInput.matches("\\d+");
    }
}
