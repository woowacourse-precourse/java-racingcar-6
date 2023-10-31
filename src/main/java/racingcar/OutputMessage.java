package racingcar;

enum OutputMessage {
    INPUT_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_COUNT("시도할 회수는 몇회인가요?"),
    RESULT("\n실행 결과"),
    WINNER("최종 우승자 : "),
    ;

    final String message;

    OutputMessage(String message) {
        this.message = message;
    }
}
