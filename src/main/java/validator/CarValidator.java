package validator;

public class CarValidator extends CommonValidator {

    public static void validateNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5글자를 초과하였습니다. 애플리케이션을 종료합니다.");
        }
    }

    public static void validateNameIncludeEmpty(String carName) {
        validateIncludeEmpty(carName);
    }
}
