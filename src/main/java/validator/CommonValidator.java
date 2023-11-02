package validator;

public class CommonValidator {

    public static void validateIncludeEmpty(String input) {
        if (isContainSpaceBar(input)) {
            throw new IllegalArgumentException("입력값이 공백을 포함하고 있습니다. 애플리케이션을 종료합니다.");
        }
    }

    private static boolean isContainSpaceBar(String input) {
        return input.contains(" ");
    }
}
