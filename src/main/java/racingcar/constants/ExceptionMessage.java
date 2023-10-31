package racingcar.constants;

public enum ExceptionMessage {
    EMPTY_NAME("비어있는 이름이 들어왔습니다."),
    EXPLODE_NAME("이름이 5자를 초과했습니다."),
    NON_NATURAL_NUMBER("자연수를 입력해야합니다."),
    DUPLICATED_NAME("중복된 이름이 존재합니다."),
    NULL_ATTEMPT_COUNT("시도 횟수를 먼저 입력해야합니다."),
    NULL_GAME_ACCESS("게임 시작 전에 게임 수행을 시도했습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}