package racingcar;

public enum Enum {

    INPUT_ERROR("입력 오류"),
    MIN_INPUT_ERROR("최소 입력 개수 오류"),
    INPUT_SPACE_ERROR("공백 입력 오류"),
    ANNOUNCE_INPUT_CAR_NAME_BY_COMMA("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ANNOUNCE_INPUT_TRIAL_COUNT("시도할 회수는 몇회인가요?"),
    RESULT("\n실행 결과"),
    DUPLICATED_INPUT_ERROR("중복 입력 오류"),
    MOVE("-"),
    WINNER("최종 우승자 : "),
    COLON(" : "),
    COMMA(","),
    SPACE(" ");

    private final String message;

    Enum(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}