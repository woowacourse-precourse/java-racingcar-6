package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarName implements UserInputWrapper {

    private String name;

    public CarName(String input) throws IllegalArgumentException {
        validate(input);
        this.name = input;
    }

    @Override
    public void validate(String input) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^[a-z, A-Z, 0-9]{1,5}$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != CarName.class) {
            return false;
        }
        return this.name.equals(((CarName) obj).name);
    }
}
