package racingcar.utils;

public class StringUtils {
    private StringUtils() {
    }

    public static String[] splitByDelimiter(String string, String delimiter) {
        return string.split(delimiter);
    }

    public static String[] stripArrayElement(String[] stringArray) {
        String[] newArr = new String[stringArray.length];
        for (int i = 0; i<stringArray.length; i++) {
            newArr[i] = stringArray[i].strip();
        }
        return newArr;
    }
}
