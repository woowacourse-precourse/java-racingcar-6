package utils;

public class TransformUtil {
    public String dashes(Integer carRunCnt) {
        StringBuilder dashes = new StringBuilder();

        if (carRunCnt != null && carRunCnt > 0) {
            dashes.append("-".repeat(carRunCnt));
        }

        return dashes.toString();
    }

}
