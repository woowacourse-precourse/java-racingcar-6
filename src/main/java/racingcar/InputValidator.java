package racingcar;

import java.util.HashSet;

public class InputValidator {

    public static void carsName(String carsName, String[] names) {
        isBlankSpace(carsName);
        isValidNameLength(names);
        isDuplicatedName(names);
        return;
    }

    private static void isBlankSpace(String names) throws IllegalArgumentException {
        if (names.contains(" ")) {
            throw new IllegalArgumentException();
        }
        return;
    }

    private static void isValidNameLength(String[] names) throws IllegalArgumentException {
        for (String name : names) {
            if (name.length() == 0 || name.length() >= 6) {
                throw new IllegalArgumentException();
            }
        }
        return;
    }

    private static void isDuplicatedName(String[] names) throws IllegalArgumentException {
        HashSet<String> nameSet = new HashSet<>();
        for (String name : names) {
            if (nameSet.contains(name)) {
                throw new IllegalArgumentException();
            }
            nameSet.add(name);
        }
        return;
    }

    public static void isStringConvertToInteger(String raceTimeString) {
        char[] raceTimeCharArray = raceTimeString.toCharArray();
        for (char raceTimeChar : raceTimeCharArray) {
            if (raceTimeChar < '0' || raceTimeChar > '9') {
                throw new IllegalArgumentException();
            }
        }
        return;
    }

}
