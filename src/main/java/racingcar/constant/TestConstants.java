package racingcar.constant;

import java.util.List;

public class TestConstants {
    // Valid Car Name Constants
    public static final String ONE_CAR_NAME = "Alice";
    public static final String THREE_CAR_NAMES = "Alice,Bob,Crong";

    public static final List<String> EXPECTED_ONE_CAR_NAME = List.of(ONE_CAR_NAME);
    public static final List<String> EXPECTED_THREE_CAR_NAMES = List.of(THREE_CAR_NAMES.split(","));


    // Invalid Constants for Car Name and Play Number
    public static final String NULL_STRING = null;
    public static final String EMPTY_STRING = "";
    public static final String BLANK_STRING = " ";

    // Invalid Car Name Constants
    public static final String LONGER_THAN_FIVE_STRING = "Pororo";


    // Valid Play Number Constants
    public static final String PLAY_ONE_TIME = "1";
    public static final String PLAY_FIVE_TIMES = "5";

    public static final String EXPECTED_PLAY_ONE_TIME = PLAY_ONE_TIME;
    public static final String EXPECTED_PLAY_FIVE_TIMES = PLAY_FIVE_TIMES;


    // Invalid Play Number Constants
    public static final String PLAY_NO_TIME = "0";
    public static final String PLAY_NEGATIVE_TIME = "-1";
    public static final String NOT_NUMBER_STRING = "a";
}
