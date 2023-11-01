package racingcar.view;

public enum ViewMessage {
    INPUT_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_NUMBER_OF_TIMES("시도할 회수는 몇회인가요?"),
    OUTPUT_RESULT("실행 결과"),
    OUTPUT_COLON(" : "),
    OUTPUT_FINAL_WINNER("최종 우승자 : ");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
