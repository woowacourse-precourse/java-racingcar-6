package racingcar.constant;

public enum Message {
    ASK_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_ROUND("시도할 회수는 몇회인가요?"),
    ROUND_RESULT_SUBJECT("실행 결과"),
    RESULT_SUBJECT("최종 우승자 : ");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
