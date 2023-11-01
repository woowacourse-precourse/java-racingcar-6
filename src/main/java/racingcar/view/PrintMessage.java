package racingcar.view;

public enum PrintMessage {

    ASK_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_COUNT_TO_TRY("시도할 회수는 몇회인가요?"),
    PRINT_RESULT("실행 결과"),
    PRINT_FINAL_WINNER("최종 우승자 : ");

    final String message;

    PrintMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}