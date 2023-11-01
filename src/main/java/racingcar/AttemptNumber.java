package racingcar;

import java.util.Objects;

public class AttemptNumber {

    private Integer count;

    public AttemptNumber(String count) {
        verifyIsNull(count);
        checkIsNumeric(count);
        this.count = Integer.parseInt(count);
    }

    public static void verifyIsNull(String strNumber) {
        if (Objects.isNull(strNumber)) {
            throw new IllegalArgumentException("please input attempt game number");
        }
    }

    public void checkIsNumeric(String strNumber) {
        try {
            Integer.parseInt(strNumber);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("only number please");
        }
    }

    public Integer getCount() {
        return count;
    }
}
