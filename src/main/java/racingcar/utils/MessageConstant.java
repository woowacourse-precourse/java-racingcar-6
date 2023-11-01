package racingcar.utils;

public final class MessageConstant {
    // InputView Message
    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_NUMBER = "시도할 회수는 몇회인가요?";

    // OutputView Message
    public static final String PRINT_RESULT = "실행 결과";
    public static final String PRINT_WINNERS = "최종 우승자 : ";

    // Error Message
    public static final String MIN_NUMBER_OF_CARS = "두 대 이상의 자동차를 입력해 주세요.";
    public static final String EXISTENCE_BLANK = "공백인 자동차 이름이 존재합니다.";
    public static final String MAX_NAME_LENGTH = "자동차 이름은 5자 이하로 입력해 주세요.";
    public static final String EXISTENCE_DUPLICATION = "중복된 자동차 이름이 존재합니다.";
    public static final String MIN_TRY_NUMBER = "1 이상의 숫자를 입력해 주세요.";

    private MessageConstant() {
        throw new AssertionError();
    }
}
