package racingcar.view;

public class InputView {
    public static final String ENTER_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ENTER_NUMBER_OF_ROUNDS_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String enterCarNamesMessage() {
        return ENTER_CAR_NAMES_MESSAGE;
    }

    public static String enterNumberOfRoundsMessage() {
        return ENTER_NUMBER_OF_ROUNDS_MESSAGE;
    }
}
