package racingcar.util.enums;

public enum Command {
    ASK_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기쥰으로 구분"),
    ASK_TRIAL("시도할 회수는 몇회인가요?"),
    ;

    private final String message;

    Command(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
