package racingcar.view.constants;

public enum NoticeMessage {
    ASK_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분\n"),
    ASK_NUMBER_OF_ATTEMPTS("시도할 회수는 몇회인가요?\n"),
    OPERATE_RESULT("실행 결과\n"),
    CHAMPION("최종 우승자 : ");

    private final String message;

    NoticeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
