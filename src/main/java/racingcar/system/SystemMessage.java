package racingcar.system;

public enum SystemMessage {

    INPUT_CAR_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_REPEAT_TIMES_MESSAGE("시도할 회수는 몇회인가요?"),
    GAME_RESULT("실행 결과\n"),
    GAME_WINNER("최종 우승자 : "),
    INPUT_OUT_OF_RANGE("입력이 범위를 초과했습니다."),
    INPUT_POSITIVE_INTEGER_ONLY("양의 정수만 입력할 수 있습니다."),
    CAR_NAME_DUPLICATED("자동차의 이름이 중복될 수 없습니다."),
    COMPETITOR_NOT_EXIST("둘 이상의 자동차 이름을 입력해 주세요.");

    private final String message;

    SystemMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
