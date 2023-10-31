package racingcar.io.enums;

public enum RaceViewMessage {

    ASK_RACERS_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_ROUND_NUMBER("시도할 회수는 몇회인가요?"),
    EXCEPTION_WRONG_NAME_LENGTH("이름의 길이는 1~5자리여야 합니다."),
    EXCEPTION_WRONG_ROUND_NUMBER("진행회수는 1~100회여야 합니다."),
    ;

    private final String message;

    RaceViewMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}
