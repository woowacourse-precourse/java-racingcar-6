package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Input {

    public static List<String> inputCarName() {
        List<String> names = new ArrayList<>();
        String s = Console.readLine();
        StringTokenizer st = new StringTokenizer(s, ",");

        while (st.hasMoreElements()) {
            names.add(st.nextToken());
        }
        checkIfNameLength(names);
        checkDuplicateName(names);

        return names;
    }

    private static void checkIfNameLength(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void checkDuplicateName(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (names.size() != nameSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static int inputNum() {
        String sNum = Console.readLine();
        checkIfNum(sNum);
        return Integer.parseInt(sNum);
    }

    private static void checkIfNum(String sNum) {
        try {
            Integer.parseInt(sNum);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }
}
