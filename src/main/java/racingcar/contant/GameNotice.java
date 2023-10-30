package racingcar.contant;

public enum GameNotice {
    GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    ROUND_NUMBER("시도할 회수는 몇회인가요?\n"),
    EXECUTE_RESULT("\n실행 결과\n"),
    NOTICE_WINNER_RESULT("\n최종 우승자 : "),
    LENGTH_NOT_MATCH("입력된 자동차 이름의 길이가 올바르지 않습니다."),
    NUM_OF_MIN_PARTICIPANT("최소 2대 이상 참가 해야 합니다."),
    CONTAINS_GAP("입력된 자동차 이름에 공백이 포함되어 있습니다."),
    INPUT_ONLY_NUMBER("숫자를 입력해주세요."),
    INPUT_ONLY_POSITIVE_NUMBER("양수만 입력 가능합니다."),
    DUPLICATE_CAR_NAME("입력된 자동차 이름 중 중복되는 값이 있습니다.");

    private final String message;

    GameNotice(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
