package view;

public class OutputView {
    public static void printHeadResult() {
        System.out.println("\n실행 결과");
    }

    public static void printWinner(String winner) {
        System.out.println(String.format("최종 우승자 : %s", winner));
    }

}
