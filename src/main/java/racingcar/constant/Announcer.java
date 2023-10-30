package racingcar.constant;

public enum Announcer {

    START_MENTION("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    ASK_NUMBER_OF_ATTEMPTS("시도할 회수는 몇회인가요?\n"),
    EXCUTION_RESULT("실행 결과\n"),
    WINNER("최종 우승자 :");


    private String message;

    Announcer(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
