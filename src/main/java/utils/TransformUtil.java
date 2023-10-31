package utils;

import java.util.Arrays;
import java.util.List;

public class TransformUtil {
    public String dashes(Integer carRunCnt) {
        StringBuilder dashes = new StringBuilder();

        if (carRunCnt != null && carRunCnt > 0) {
            dashes.append("-".repeat(carRunCnt));
        }

        return dashes.toString();
    }

    public String commasToString(List<String> winnerData) {
        return String.join(",", winnerData);
    }

    public List<String> commasToList(String carData) {
        String[] dataArray = carData.split("\\s*,\\s*");

        return Arrays.asList(dataArray);
    }

}
