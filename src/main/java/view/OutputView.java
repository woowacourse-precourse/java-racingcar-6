package view;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String ONE_SPACE ="-";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCurrentLocationOfCar(String name, int distance) {
        System.out.printf("%s : ",name);
        for(int i=0; i < distance; i++) {
            System.out.print(ONE_SPACE);
        }
        System.out.println();
    }

    public static void printWinnerMessage(String name) {
        System.out.print(WINNER_MESSAGE);
        System.out.println(name);
    }
}
