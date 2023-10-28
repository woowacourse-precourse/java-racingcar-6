package View;

public class OutputView {
    private static final String resultMessage = "실행 결과";
    private static final String winnerMessage = "최종 우승자 : ";
    public static void printResultMessage(){
        System.out.println(resultMessage);
    }

    public static void printWinnerMessage(){
        System.out.print(winnerMessage);
    }

}
