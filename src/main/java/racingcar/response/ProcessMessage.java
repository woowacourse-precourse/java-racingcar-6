package racingcar.response;

public enum ProcessMessage {
    REQUIRE_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUIRE_TRY_NUMBER_MESSAGE("시도할 회수는 몇회인가요? "),
    PRINT_FINAL_WINNER("최종 우승자 : ");

    private final String msg;

    public String getMsg() {
        return msg;
    }

    ProcessMessage(String msg) {
        this.msg = msg;
    }
}
