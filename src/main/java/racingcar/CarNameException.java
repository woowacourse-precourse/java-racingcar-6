package racingcar;

import java.util.List;

public class CarNameException {
    CarNameException() {
    }

    public boolean isValidNameLength(List<String> nameList) {
        final int maxNameLength = 5;
        for (String carName : nameList) {
            if (carName.length() == 0 || carName.length() > maxNameLength) return false;
        }
        return true;
    }

    public boolean isBlankString(List<String> nameList) {
        for (String carName : nameList) {
            if (carName.isBlank()) return true;
        }
        return false;
    }

    public void isException(List<String> nameList) throws IllegalArgumentException {
        if (!isValidNameLength(nameList) || isBlankString(nameList)) throw new IllegalArgumentException();
    }

}
