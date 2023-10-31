package racingcar;

public enum MessageType {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_NUMBER("시도할 횟수는 몇회인가요?"),
    SHOW_RUN_RESULT("\n실행 결과"),
    SHOW_WINNERS("최종 우승자 : ");

    private final String detail;

    MessageType(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
}
