package racingcar.code;

public enum Message {
    GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT("시도할 회수는 몇회인가요?"),
    ;

    private String description;

    Message(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
