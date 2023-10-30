package racingcar;

import java.util.StringTokenizer;

public class Validator {
    private static Validator validator = new Validator();

    private Validator() {}

    public static Validator getInstance() {
        return validator;
    }

    public void validateInputCarList(String input) throws IllegalArgumentException {
        StringTokenizer st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens()) {
            String car = st.nextToken();
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}

