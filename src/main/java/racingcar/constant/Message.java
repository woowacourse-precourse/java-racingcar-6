package racingcar.constant;

public enum Message {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_TRY_COUNT("시도할 회수는 몇회인가요?"),
    TRY_RESULT("\n실행 결과"),
    FINAL_WINNERS("최종 우승자 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}