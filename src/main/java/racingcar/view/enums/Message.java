package racingcar.view.enums;

public enum Message {
    START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    PLAY_ROUND_MESSAGE("시도할 회수는 몇회인가요?"),
    PLAY_RESULT_MESSAGE("실행 결과"),
    PLAY_WINNER_MESSAGE("최종 우승자 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
