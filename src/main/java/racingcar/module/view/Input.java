package racingcar.module.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import racingcar.global.utils.Validator;

public class Input {

    private static final String SEPARATOR = ",";

    public static List<String> readCarNames() {
        String input = readLine();
        List<String> nameList = separateNames(input);

        Validator.validateCarName(nameList);

        return nameList;
    }

    private static List<String> separateNames(String input) {
        List<String> nameList = new ArrayList<>();
        String[] arr = input.split(SEPARATOR);
        nameList.addAll(List.of(arr));
        return nameList;
    }

    public static int readTrialNumber() {
        return Integer.parseInt(readLine());
    }
}
