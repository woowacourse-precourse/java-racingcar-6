package racingcar.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.View.OutputView;

public class Car {
    private static final String REGEX = "^[a-zA-Z0-9]+$";
    private static final int START_LOCATION = 0;
    private final String name;
    private int location;

    private Car(String name) {
        this.name = name;
        this.location = START_LOCATION;
    }

    public static Car from(String name) {
        validateNameLength(name);
        validateNameHasOnlyAlphaNumeric(name);
        return new Car(name);
    }

    private static void validateNameLength(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException(OutputView.NAME_LENGTH_OVER);
        }
    }

    private static void validateNameHasOnlyAlphaNumeric(String name) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(name);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(OutputView.NAME_HAS_ANOTHER_CHARACTER);
        }
    }

    public void goForward(Car car) {
        int presentLocation = car.getLocation();
        setLocation(presentLocation + 1);
    }

    private int getLocation() {
        return location;
    }

    private void setLocation(int location) {
        this.location = location;
    }
}
