package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import static racingcar.controller.CheckInput.*;

public class Input {

    public static List<String> inputCarName() {
        List<String> names = new ArrayList<>();
        String s = Console.readLine();
        StringTokenizer st = new StringTokenizer(s, ",");

        while (st.hasMoreElements()) {
            names.add(st.nextToken());
        }
        checkNameLength(names);
        checkDuplicateName(names);

        return names;
    }


    public static int inputNum() {
        String sNum = Console.readLine();
        checkIfNum(sNum);
        return Integer.parseInt(sNum);
    }


}
