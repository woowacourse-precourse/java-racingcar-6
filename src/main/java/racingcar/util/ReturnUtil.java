package racingcar.util;

import java.util.ArrayList;

public class ReturnUtil {
    public static String statusFormat(int number) {
        String oneMove = "-";
        return oneMove.repeat(number);
    }

    public static String stageResultFormat(String car, String status) {
        StringBuilder sb = new StringBuilder();
        sb.append(car);
        sb.append(" : ");
        sb.append(status);
        return sb.toString();
    }

    public static String winnerResultFormat(ArrayList<String> winners) {
        StringBuilder sb = new StringBuilder();
        for (String winner : winners) {
            sb.append(winner);
            sb.append(",");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
