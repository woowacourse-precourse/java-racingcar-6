package racingcar.constant;

public enum RaceInfoMessage {
    EACH_FORWARD_INFORMATION("-"),
    INPUT_CAR_NAMES_INFO("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_MOVEMENT_TIME_INFO("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULTS_INFO("\n실행 결과"),
    FINAL_WINNER_INFO("최종 우승자 : ");

    private String message;

    private RaceInfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
