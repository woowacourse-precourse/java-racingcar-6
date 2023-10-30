package domain;

public class ValidateInput {


    public static void nameLengthException(String nameString) {
        String[] names = nameString.split(ConstantUtil.NAME_STRING_DELIMINATOR);
        for (String name : names) {
            if (name.length() >= ConstantUtil.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }
}
