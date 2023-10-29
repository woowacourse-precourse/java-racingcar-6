package racingcar.constant;

public class Rule {

    public static final Integer MIN_LENGTH = 1;
    public static final Integer MAX_LENGTH = 5;
    public static final Integer MIN_POSSIBILITY = 0;
    public static final Integer MAX_POSSIBILITY = 9;
    public static final Integer MOVING_POSSIBILITY = 4;
    public static final Integer MIN_PARTICIPANT = 1;
    public static final String VALID_RANGE = "^[" + MIN_POSSIBILITY + "-" + MAX_POSSIBILITY + "]+";

    private Rule() {
    }
}
