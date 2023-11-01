package racingcar.message;

public enum Message {
    INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    WINNER("최종 우승자"),
    ERROR_LONG_NAME("자동차 이름은 5자 이하로만 입력해야 합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getWinner(String winner) {
        return String.format("%s : %s", this.WINNER.getMessage(), winner);
    }
}
