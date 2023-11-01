package racingcar.view;

public class OutputView {
    private final static String RESULTMESSAGE = "실행 결과";

    public static void showResultMessage() {
        System.out.println(RESULTMESSAGE);
    }

    public static void showCarDistanceResults(String name, String distance) {
        System.out.print(name + " : ");
        for (int i = 0; i < distance.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
