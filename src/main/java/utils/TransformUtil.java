package utils;

import java.util.List;

public class TransformUtil {
    public static String dashes(Integer carRunCnt) {
        StringBuilder dashes = new StringBuilder();

        if (carRunCnt != null && carRunCnt > 0) {
            dashes.append("-".repeat(carRunCnt));
        }

        return dashes.toString();
    }

    public static String commasToString(List<String> winnerData) {
        return String.join(",", winnerData);
    }

    public static List<String> commasToList(String carData) {
        return List.of(carData.split("\\s*,\\s*"));
    }

}
