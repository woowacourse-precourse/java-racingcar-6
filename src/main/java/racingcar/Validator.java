package racingcar;

public class Validator {
    public static boolean validateCarName(String splittedName) throws IllegalArgumentException {
        if (splittedName.length() <= 5) {
            return true;
        }
        throw new IllegalArgumentException("올바르지 않은 이름입니다.");
    }

}
