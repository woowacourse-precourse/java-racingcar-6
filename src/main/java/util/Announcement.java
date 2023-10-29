package util;

public enum Announcement {
    ENTER_CAR_NAMES("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
    ENTER_NUMBER_OF_ATTEMPTS("시도할 회수는 몇 회인가요?"),
    EXECUTION_RESULT("\n실행 결과"),
    FINAL_WINNER("최종 우승자 : ");

    private final String message;

    Announcement(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
