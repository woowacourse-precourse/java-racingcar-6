package racingcar.util;

public class TestUtil {

    public static String stringArrayToString(String[] strings) {
        StringBuilder outText = new StringBuilder();

        for (String string :
                strings) {
            if (!outText.isEmpty()) {
                outText.append(",");
            }
            outText.append(string);
        }

        return outText.toString();
    }
}
