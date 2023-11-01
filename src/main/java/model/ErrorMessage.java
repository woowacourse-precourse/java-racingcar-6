package model;

public enum ErrorMessage {

    DUPLICATED_CAR_NAME("중복되는 이름이 있습니다!"),
    INVALID_RANGE(String.format("최소 시도 횟수는 %d회입니다!", Constants.MIN_TRY_COUNT)),
    INVALID_TYPE("유효하지 않은 형식입니다!"),
    INVALID_NAME_LENGTH(
        String.format("이름의 길이는 %d자 이상, %d자 이하여야 합니다!", Constants.MIN_NAME_LENGTH,
            Constants.MAX_NAME_LENGTH));

    private static class Constants {

        private static final int MIN_NAME_LENGTH = 1;
        private static final int MAX_NAME_LENGTH = 5;
        private static final int MIN_TRY_COUNT = 1;
    }

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
