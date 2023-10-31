package racingcar.configurations;

public class InputConfigurations {
    private static final int maximumNameLength = 5;
    private static final String delimiter = ",";

    public static int getMaximumNameLength() {
        return maximumNameLength;
    }
    public static String getDelimiter(){
        return delimiter;
    }
}
