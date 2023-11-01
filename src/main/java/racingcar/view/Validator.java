package racingcar.view;

public class Validator {
    public static boolean validateInputExist(String inputData) {
        return inputData.isEmpty();
    }

    public static boolean validateInputIsZero(String inputData) {
        return Integer.parseInt(inputData) == 0;
    }

    public static boolean validateInputNotNum(String inputData) {
        for (char ch : inputData.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

}