package util;

public enum CarsNameErrorMessage {
    EMPTY_CARS("아무것도 입력하지 않았습니다."),
    DUPLICATE_CARS("차의 이름이 중복되었습니다.");

    private final String message;

    CarsNameErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
