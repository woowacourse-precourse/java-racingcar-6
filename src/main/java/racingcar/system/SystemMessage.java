package racingcar.system;

public enum SystemMessage {

    INPUT_CAR_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_REPEAT_TIMES_MESSAGE("시도할 회수는 몇회인가요?"),
    GAME_WINNER("최종 우승자 : "),
    INPUT_OUT_OF_RANGE("입력이 범위를 초과했습니다."),
    ONLY_NUMBER_INPUT_AVAILABLE("숫자 이외에는 입력할 수 없습니다.");

    private final String message;

    SystemMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
