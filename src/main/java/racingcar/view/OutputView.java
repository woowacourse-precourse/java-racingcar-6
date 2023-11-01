package racingcar.view;

public class OutputView {

    private OutputView() {
    }

    public static void printSingleMoveResult(final String result) {
        System.out.println(result);
    }

    public static void printWinnerNames(final String names) {
        System.out.print("최종 우승자 : ");
        System.out.println(names);
    }
}
