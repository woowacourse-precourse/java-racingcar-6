package racingcar.constant;

public enum GameMessage {
    ASK_INPUT_INSTRUCT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_ATTEMPT_COUNT_MESSAGE("시도할 회수는 몇회인가요?"),
    GAME_RESULT_MESSAGE("실행 결과"),
    GAME_WINNER_MESSAGE("최종 우승자"),
    VALIDATE_INPUT_ERROR_MESSAGE("입력 형식이 옳지 않습니다."),
    VALIDATE_NAME_LENGTH_ERROR_MESSAGE("이름의 길이는 5자리를 넘을 수 없습니다.");

    private final String value;

    GameMessage(String msg){
        this.value = msg;
    }
    public String getValue(){
        return value;
    }
}


