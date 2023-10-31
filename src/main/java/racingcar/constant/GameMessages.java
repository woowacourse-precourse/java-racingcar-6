package racingcar.constant;

public enum GameMessages {
    RESULT("실행 결과"),
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_REPEAT_COUNT("시도할 회수는 몇회인가요?"),
    GAME_RESULT("최종 우승자 : ");

    private final String message;

    GameMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
