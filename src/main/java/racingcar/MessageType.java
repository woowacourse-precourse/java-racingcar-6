package racingcar;

public enum MessageType {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_NUMBER("시도할 횟수는 몇회인가요?"),
    SHOW_RUN_RESULT("\n실행 결과"),
    SHOW_WINNERS("최종 우승자 : "),
    CAR_NAMES_LENGTH_ERR(String.format("최대 이름길이 %d를 넘는 이름입니다.", Constant.MAX_NAME_LENGTH)),
    CAR_NAMES_DUPLICATE_ERR("이름 중에 중복이 있습니다."),
    TRY_NUMBER_INPUT_ERR("시도 횟수가 정수 값이 아닙니다.")
    ;

    private final String detail;

    MessageType(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
}
