package racingcar.enums;

public enum ApplicationMessage {

    EXCEPTION_APPLICATION("잘못된 동작으로 인해 프로그램을 종료합니다."),
    ;

    private final String message;

    ApplicationMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}
