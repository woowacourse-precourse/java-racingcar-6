package racingcar.constant;

import java.util.List;

public class InputViewTestConstant {
    public static final String NULL_VALUE = null;
    public static final String BLANK_VALUE = "";

    public class CarNameTest {
        public static final String SUCCESSFUL_CAR_NAMES = "pobi,woni,jun";
        public static final List<String> SUCCESSFUL_CAR_NAMES_LIST = List.of("pobi", "woni", "jun");
        public static final String EXCEED_LENGTH_TEST = "pobbii,woni,jun";
        public static final String DUPLICATE_CAR_NAMES_TEST = "pobi, woni, pobi, jun";
    }

    public class MovementTimeTest {
        public static final String SUCCESSFUL_MOVEMENT_TIME = "10";
        public static final String INVALID_TYPE_MOVEMENT_TIME = "12a";
    }
}
