package racingcar;

public enum SystemMessage implements Message {

    INPUT_THE_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_THE_NUMBER_OF_ATTEMPTS("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT_PREFIX("실행 결과"),
    OUTPUT_THE_WINNER_PREFIX("최종 우승자 : ");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
