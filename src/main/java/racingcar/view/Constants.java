package racingcar.view;

public enum Constants {
    /*
    입력 안내 메시지
     */
    INPUT_CARS_NAME_MESSAGE("경주할 자동차 이름을 입력하세.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_MESSAGE("시도할 횟수는 몇회인가요?"),
    /*
    출력 안내 메시지
     */
    RESULT_MESSAGE_START("\n실행결과\n"),
    WINNER_IS("최종 우승자 : "),
    NEXT_LINE("\n");
    private final String message;

    Constants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
