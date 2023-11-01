package racingcar.utils;
import java.util.ArrayList;
import java.util.Arrays;

public class CarNameValidator {
    public static final int NAME_SIZE = 5;
    public static final String COMMA = ",";
    public final ArrayList<String> NAMES;

    public CarNameValidator(String name) {
        this.NAMES = toArrayList(name);
        validate();
    }

    private ArrayList<String> toArrayList(String cars) {
        return new ArrayList<>(Arrays.asList(cars.split(COMMA)));
    }

    public void validate() {
        isNameNoDuplicate();
        isRightNameSize();
    }

    private void isNameNoDuplicate() {
        if (NAMES.size() != NAMES.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void isRightNameSize() {
        if (NAMES.stream().anyMatch(name -> name.isEmpty() || name.length() > NAME_SIZE)) {
            throw new IllegalArgumentException();
        }

    }
}
