package view;

public class OutputView {
    public static void printHeadResult() {
        System.out.print("\n실행 결과\n");
    }

    public static void printWinner(String winner) {
        System.out.print(String.format("최종 우승자 : %s", winner));
    }

}
