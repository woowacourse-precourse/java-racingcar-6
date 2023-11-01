package racingcar.module.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public static List<String> readCarNames() {
        String names = readLine();
        return separateNames(names);
    }

    private static List<String> separateNames(String names) {
        List<String> nameList = new ArrayList<>();
        String[] arr = names.split(",");
        nameList.addAll(List.of(arr));
        return nameList;
    }

    public static int readTrialNumber() {
        return Integer.parseInt(readLine());
    }
}
