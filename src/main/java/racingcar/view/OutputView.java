package racingcar.view;

import java.util.List;

public class OutputView {
    private final static String RESULTMESSAGE = "실행 결과";
    private final static String WINNERMESSAGE = "최종 우승자 : ";
    private final static String HYPHEN = "-";

    public static void showResultMessage() {
        System.out.println(RESULTMESSAGE);
    }

    public static void showCarDistanceResults(String name, String distance) {
        System.out.print(name + " : ");
        for (int i = 0; i < distance.length(); i++) {
            System.out.print(HYPHEN);
        }
        System.out.println();
    }

    public static String createDistanceString(int distance) {
        StringBuilder distanceString = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            distanceString.append(HYPHEN);
        }
        return distanceString.toString();
    }

    public static void winnerResult(List<String> winnerCars) {
        System.out.println(WINNERMESSAGE + String.join(", ", winnerCars));
    }
}
