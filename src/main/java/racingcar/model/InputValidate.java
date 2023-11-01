package racingcar.model;

public class InputValidate {
    final static String REGREX = "";

    public static String[] isValidParticipant (String[] nameList) {
        if (checkUnderBound(nameList) && checkName(nameList)) {
            return nameList;
        } throw new IllegalArgumentException();
    }

    public static String isValidNumber (String inputNumber) {
        return "";
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
