package racingcar.model;

public class InputValidate {
    final static String REGREX = "^[0-9]+$";

    public static String[] isValidParticipant (String[] nameList) {
        if (checkUnderBound(nameList) && checkName(nameList)) {
            return nameList;
        } throw new IllegalArgumentException();
    }

    public static String isValidNumber (String inputNumber) {
        if (inputNumber.matches(REGREX)) {
            return inputNumber;
        } throw new IllegalArgumentException();
    }

    private static boolean checkUnderBound (String[] nameList) {
        return !(nameList.length == 0);
    }

    private static boolean checkName (String[] nameList) {
        for (String carName : nameList) {
            String trimName = carName.trim();
            if (carName.length() != trimName.length()) {
                return false;
            }
            if (trimName.isEmpty()) {
                return false;
            }
            if (trimName.length() > 5) {
                return false;
            }
        }
        return true;
    }

}
