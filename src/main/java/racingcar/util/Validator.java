package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private final Formatter formatter = Formatter.getInstance();

    public static Validator getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final Validator INSTANCE = new Validator();
    }

    public List<String> checkValidInputList(String input) {
        checkNull(input);
        List<String> carNameList = formatter.splitToList(input);
        boolean isValid = hasTwoOrMore(carNameList) && !hasDuplicates(carNameList);

        if (!isValid) {
            throw new IllegalArgumentException();
        }
        return carNameList;
    }

    public int checkValidInputNumber(String input) {
        checkNull(input);
        boolean isValid = input.matches("^[1-9]\\d*$");

        if(!isValid) {
            throw new IllegalArgumentException();
        }

        return formatter.changeToInt(input);
    }

    private void checkNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasTwoOrMore(List<String> list) {
        return list.size() >= 2;
    }

    private boolean hasDuplicates(List<String> list) {
        Set<String> uniqueNames = new HashSet<>();
        for (String item : list) {
            if (!uniqueNames.add(item.trim())) {
                return true;
            }
        }
        return false;
    }
}
