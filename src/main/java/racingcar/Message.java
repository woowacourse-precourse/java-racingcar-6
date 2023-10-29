package racingcar;

public enum Message {
    CAR_NAME_REQUEST("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_REQUEST("시도할 회수는 몇회인가요?"),
    RESULT_RACING_INFO("\n실행 결과"),

    FINAL_WINNER_INFO("최종 우승자 : "),
    DELIMITER_SPLIT_CARS(",");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
