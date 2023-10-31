package racingcar.utils;
import java.util.ArrayList;

public class CarNameValidator {
    public static final int NAME_SIZE = 5;
    public final ArrayList<String> NAMES;

    public CarNameValidator(String name) {
        this.NAMES = Util.toArrayList(name);
        validate();
    }

    public void validate() {
        isNameNoDuplicate();
        isRightNameSize();
    }

    public void isNameNoDuplicate() {
        if (NAMES.size() != NAMES.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public void isRightNameSize() {
        if (NAMES.stream().anyMatch(name -> name.isEmpty() || name.length() > NAME_SIZE)) {
            throw new IllegalArgumentException();
        }

    }
}
