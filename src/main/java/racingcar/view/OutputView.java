package racingcar.view;

import racingcar.model.MoveInfo;

import java.util.List;

public class OutputView {
    private static final String RESULT_TITLE = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String RESULT_SIGN = "-";

    private OutputView() {
        // 생성자 호출 방지
    }

    public static void printResultTitle() {
        System.out.println();
        System.out.println(RESULT_TITLE);
    }

    public static void printResult(MoveInfo info) {
        System.out.print(info.name + " : ");
        System.out.println(RESULT_SIGN.repeat(info.moved));
    }

    public static void printFinalWinner(List<String> names) {
        System.out.print(FINAL_WINNER);
        System.out.println(String.join(", ", names));
    }
}
