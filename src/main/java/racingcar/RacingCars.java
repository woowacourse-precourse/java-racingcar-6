package racingcar;

import java.util.List;

public class RacingCars {

    public static final int MAX_NAME_LENGTH = 5;
    private final List<String> names;

    public RacingCars(List<String> names) {
        for (String name: names) {
            verifyNotTooLongName(name);
        }
        this.names = names;
    }

    private void verifyNotTooLongName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("car name length should be under " + MAX_NAME_LENGTH);
        }
    }

    public List<String> getNames() {
        return names;
    }
}
