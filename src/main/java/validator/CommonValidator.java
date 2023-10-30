package validator;

public class CommonValidator {

    public static void validateIncludeEmpty(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름이 공백을 포함하고 있습니다. 애플리케이션을 종료합니다.");
        }
    }
}
