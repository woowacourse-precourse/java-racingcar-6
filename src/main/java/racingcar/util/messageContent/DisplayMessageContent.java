package racingcar.util.messageContent;

public enum DisplayMessageContent {
    CAR_NICKNAME_REGISTER("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    GAME_TIME("시도할 회수는 몇회인가요?"),
    PLAY_RESULT_TITLE("게임 결과"),
    GAME_WINNER("최종 우승자 : "),
    MOVE_DISPLAY_STRING("-"),
    DIVIDING_LINE(" : ");

    private final String content;

    DisplayMessageContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
