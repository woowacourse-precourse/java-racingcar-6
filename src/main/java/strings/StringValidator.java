package strings;

public final class StringValidator {
    public static void validateString(final String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("null이거나 공백인 문자열을 사용할 수 없습니다.");
        }
    }
}
