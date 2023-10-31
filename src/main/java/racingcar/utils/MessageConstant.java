package racingcar.utils;

public final class MessageConstant {

    // InputView Message
    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    // OutputView Message
    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";

    // Error Message
    public static final String BLANK_MESSAGE = "공백인 자동차 이름이 존재합니다.";
    public static final String MAX_CAR_NAME_LENGTH_MESSAGE = "자동차 이름은 5자 이하로 입력해 주세요.";
    public static final String MAX_FREQUENCY_MESSAGE = "중복된 자동차 이름이 존재합니다.";
    public static final String MIN_TRY_NUMBER_MESSAGE = "1 이상의 숫자를 입력해 주세요.";

    private MessageConstant() {
        throw new AssertionError();
    }
}
