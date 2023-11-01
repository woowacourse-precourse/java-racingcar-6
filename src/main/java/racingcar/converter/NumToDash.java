package racingcar.converter;

public class NumToDash {
    public static String createDashString(int count) {
        StringBuilder dashString = new StringBuilder();
        for (int i = 0; i < count; i++) {
            dashString.append("-");
        }
        return dashString.toString();
    }
}
