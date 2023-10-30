package racingcarv2.view;

public class OutputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_TOTAL_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void printInputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public static void printInputRoundTotal() {
        System.out.println(INPUT_ROUND_TOTAL_MESSAGE);
    }
}
