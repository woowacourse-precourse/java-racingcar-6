package validator;

public class CarValidator extends CommonValidator {

    public static void validateNameLength(String carName) {
        if (isGreaterThanFive(getLength(carName))) {
            throw new IllegalArgumentException("자동차 이름이 5글자를 초과하였습니다. 애플리케이션을 종료합니다.");
        }
    }

    public static void validateNameIncludeEmpty(String carName) {
        validateIncludeEmpty(carName);
    }

    private static int getLength(String input) {
        return input.length();
    }
    private static boolean isGreaterThanFive(int length) {
        return length > 5;
    }
}
