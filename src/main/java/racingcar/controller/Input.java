package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import static racingcar.controller.CheckInput.*;

public class Input {

    public static List<String> inputCarName() {
        String s = Console.readLine();
        List<String> names = splitCarName(s);
        checkNameLength(names);
        checkDuplicateName(names);
        return names;
    }

    public static List<String> splitCarName(String s) {
        List<String> names = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s, ",");
        while (st.hasMoreElements()) {
            names.add(st.nextToken());
        }
        return names;
    }


    public static int inputNum() {
        String sNum = Console.readLine();
        checkIfNum(sNum);
        return Integer.parseInt(sNum);
    }


}
