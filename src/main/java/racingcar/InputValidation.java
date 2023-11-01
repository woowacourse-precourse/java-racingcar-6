package racingcar;

import java.util.HashMap;
import java.util.Map;

import static racingcar.Car.MAX_CAR_NAME_LENGTH;

public class InputValidation {

    private Map<String, Integer> nameCount = new HashMap<>();

    void checkNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String checkDuplicateName(String name) {
        if (nameCount.containsKey(name)) {
            Integer sameNameCount = nameCount.get(name) + 1;
            nameCount.put(name, sameNameCount);
            return name + sameNameCount;
        }
        nameCount.put(name, 1);
        return name;
    }

    public void initNameCount() {
        nameCount.clear();
    }

    int validNum(String input) {
        boolean matches = input.matches("^[0-9]+$");

        if (!matches) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }
}
