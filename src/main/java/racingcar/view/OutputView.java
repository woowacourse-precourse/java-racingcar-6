package racingcar.view;

public class OutputView {
    private static final String NAME_INPUT_DESC = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_COUNT_INPUT_DESC = "시도할 회수는 몇회인가요?";

    public static void printNameInputDescription() {
        System.out.println(NAME_INPUT_DESC);
    }

    public static void printMoveCountInputDescription() {
        System.out.println(MOVE_COUNT_INPUT_DESC);
    }
}
