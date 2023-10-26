package validation;


import java.util.LinkedHashMap;
import java.util.Map;

public class ValidationMan {
    private ValidationMan() {
    }

    private static final ValidationMan singleMan = new ValidationMan();

    public static ValidationMan getInstance() {
        return singleMan;
    }

    private final static int MAXNAMELENGTH = 5;

    public void checkException(LinkedHashMap<String, StringBuilder> map, int userInputNum)
            throws IllegalArgumentException {
        if (map.size() != userInputNum) {
            throw new IllegalArgumentException("Duplicated Name");
        }
        checkException(map);
    }

    private void checkException(LinkedHashMap<String, StringBuilder> map)
            throws IllegalArgumentException {
        for (Map.Entry<String, StringBuilder> entry : map.entrySet()) {
            if (entry.getKey().length() > MAXNAMELENGTH) {
                throw new IllegalArgumentException("input within 5letters");
            }
        }
    }

    public void checkException(String userTimes) throws IllegalArgumentException {
        if (!userTimes.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }
}
