package racingcar.input.name;
public class NameLengthValidator {
    public static boolean hasValidLength(String name) {
        return !name.isEmpty() && name.length() <= 5;
    }
}
