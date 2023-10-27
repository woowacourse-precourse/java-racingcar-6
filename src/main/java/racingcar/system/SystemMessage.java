package racingcar.system;

public enum SystemMessage {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    INPUT_NUMBER_OF_TRY("시도할 회수는 몇회인가요?\n"),
    RACE_RESULT("\n실행 결과\n"),
    FINAL_WINNER("최종 우승자 : ");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
