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

    public boolean checkException(LinkedHashMap<String, StringBuilder> map, int userInputNum)
    {
        if (map.size() != userInputNum) {
            return false;
        }
        return checkException(map);
    }

    private boolean checkException(LinkedHashMap<String, StringBuilder> map) {
        for (Map.Entry<String, StringBuilder> entry : map.entrySet()) {
            if (entry.getKey().length() > MAXNAMELENGTH) {
                return false;
            }
        }
        return true;
    }

    public boolean checkException(String userTimes){
        if (!userTimes.matches("\\d+")) {
            return false;
        }
        return true;
    }
}
