package racingcar.validator;

import static racingcar.ConstantValue.MAX_LEN_OF_CAR_NAME;
import static racingcar.ConstantValue.MIN_NUM_OF_CAR;
import static racingcar.ConstantValue.MIN_NUM_OF_MATCHES;

public class ErrorMessage {
    public final static String BLANK = "Blank is not Name";
    public final static String DUPLICATE = "CarList has duplicated name";
    public final static String LESS_THAN_MIN_NUM_OF_CAR = "Less than the minimum number of cars : " + MIN_NUM_OF_CAR;
    public final static String EXCEED_MAX_LEN_OF_CAR_NAME = "The car name exceeds"
            + MAX_LEN_OF_CAR_NAME + "characters in length.";
    public final static String NOT_INTEGER = "Not integer";
    public final static String LESS_THAN_MIN_NUM_OF_MATCHES = "Less than the minimum number of matches : "
            + MIN_NUM_OF_MATCHES;
}
