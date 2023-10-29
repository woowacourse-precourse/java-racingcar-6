package racingcar.constant;

import java.util.List;

public class TestConstants {
    // Valid Car Name Constants
    public static final String ONE_CAR_NAME = "Alice";
    public static final String THREE_CAR_NAMES = "Alice,Bob,Crong";

    public static final List<String> EXPECTED_ONE_CAR_NAME = List.of(ONE_CAR_NAME);
    public static final List<String> EXPECTED_THREE_CAR_NAMES = List.of(THREE_CAR_NAMES.split(","));


    // Invalid Car Name Constants
    public static final String NULL_STRING = null;
    public static final String EMPTY_STRING = "";
    public static final String BLANK_STRING = " ";
    public static final String LONGER_THAN_FIVE_STRING = "Pororo";
}
