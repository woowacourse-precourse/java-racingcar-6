package racingcar.common.validator;

public class NameValidator {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 20;
    private static final String VALID_NAME_PATTERN = "^[a-zA-Z가-힣_]+$";

    // 이름 검증을 담당하는 정적 메서드
    public static void validate(String name) {
        validateNullAndLength(name);
        validatePattern(name);
    }

    // Null과 길이 검증
    private static void validateNullAndLength(String name) {
        if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MIN_NAME_LENGTH + "자 이상, " + MAX_NAME_LENGTH + "자 이하이어야 합니다.");
        }
    }

    // 패턴 검증
    private static void validatePattern(String name) {
        if (!name.matches(VALID_NAME_PATTERN) || name.contains(" ")) {
            throw new IllegalArgumentException("이름은 알파벳, 한글, 언더바만 포함할 수 있으며, 특수문자나 숫자, 공백은 포함할 수 없습니다.");
        }
    }
}
