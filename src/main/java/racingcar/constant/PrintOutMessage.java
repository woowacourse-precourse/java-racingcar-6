package racingcar.constant;

public enum PrintOutMessage {
    PLZ_INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),

    PLZ_INPUT_TRY_COUNT("시도할 회수는 몇회인가요?"),

    EXECUTE_GAME("실행 결과"),
    WINNER_NAME("최종 우승자 : ");

    public final String message;

    PrintOutMessage(String message) {
        this.message = message;
    }
}
