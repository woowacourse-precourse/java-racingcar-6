package racingcar.message;

public enum ConsoleMessage {
    START_GAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분"),
    INPUT_TRY_COUNT("시도할 회수는 몇회인가요?"),
    OUT_RESULT("실행 결과"),
    OUTPUT_WINNER("최종 우승자 : "),
    ;
    ;
    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
