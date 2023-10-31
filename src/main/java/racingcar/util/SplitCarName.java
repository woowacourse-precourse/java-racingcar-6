package racingcar.util;

public class SplitCarName {

    private static final String SPLIT_DELIMITER = ",";

    public static String[] splitCarNames(String input){
        return input.split(SPLIT_DELIMITER);
    }
}
