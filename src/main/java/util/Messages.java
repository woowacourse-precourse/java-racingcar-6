package util;

public enum Messages {
    CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRIAL_INPUT("시도할 회수는 몇회인가요?"),

    ERROR_NAME_LENGTH("이름은 %d자를 넘지 못합니다."),
    ERROR_TRIAL_NUMBER("게임 시도 횟수는 음수가 되면 안됩니다. 현재 작성한 횟수: %d"),
    ERROR_EXCEED_MAX_RANGE("너무 많은 횟수입니다"),
    ERROR_NOT_NUMBER("숫자가 아닌 값이 입력되었습니다."),

    INFO_END("최종 우승자 : ")
    ;

    private final String message;

    Messages(String message){
        this.message = message;
    }
    @Override
    public String toString() {
        return this.message;
    }
}
