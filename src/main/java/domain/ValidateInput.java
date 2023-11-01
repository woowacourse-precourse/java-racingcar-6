package domain;

public class ValidateInput {


    public static void nameLengthException(String nameString) {
        String[] names = nameString.split(ConstantUtil.NAME_STRING_DELIMINATOR);
        for (String name : names) {
            if (name.length() >= ConstantUtil.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ConstantUtil.NAMES_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    public static void numberFormatException(String numberString) {
        for (int i = 0; i < numberString.length(); i++) {
            char number = numberString.charAt(i);
            if (number < '0' || number > '9') {
                throw new IllegalArgumentException(ConstantUtil.NUMBER_FORMAT_ERROR_MESSGE);
            }
        }
    }
}
