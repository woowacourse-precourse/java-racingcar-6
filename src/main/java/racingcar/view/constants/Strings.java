package racingcar.view.constants;

public enum Strings {

    ASK_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_PLAY_TIME("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    FINAL_WINNER("최종 우승자 : "),
    NULL_OR_EMPTY_ERROR("입력이 비어있거나 null 값입니다"),
    NUMBER_OF_CARS_ERROR("자동차 수가 너무 적거나 많습니다"),
    INVALID_LETTER_ERROR("올바른 문자를 입력해주세요"),
    DUPLICATED_CAR_NAME_ERROR("중복된 이름을 가질 수 없습니다"),
    LENGTH_OF_CAR_NAME_ERROR("유효하지 않은 자동차 이름 길이입니다."),
    LAST_CHARACTER_IS_COMMA_ERROR("구분자는 이름 사이에만 사용 가능합니다."),
    PLAYTIME_OUT_OF_RANGE_ERROR("시도 횟수가 너무 많거나 적습니다."),
    VALID_CAR_NAME_LETTERS("abcdefghijklmnopqrstuvwxyz,"),
    VALID_PLAYTIME_LETTERS("0123456789");
    private final String string;

    Strings(String string) {
        this.string = string;
    }

    public String getMessage() {
        return string;
    }
}