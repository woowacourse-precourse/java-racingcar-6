package racingcar.constant;

public enum InformationResponse {
    WINNER("최종 우승자 : "),
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRIAL_COUNT("시도할 회수는 몇회인가요?");

    private String message;

    InformationResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
