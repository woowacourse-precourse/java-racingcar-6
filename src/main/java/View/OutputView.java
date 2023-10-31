package View;

public class OutputView {

    public static void printExcuteResult() {
        System.out.println("실행 결과");
    }

    public static void printWinner(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

    public static void printPlayerState(String status) {
        System.out.println(status);
    }

    public static void printLn() {
        System.out.println();
    }
}
