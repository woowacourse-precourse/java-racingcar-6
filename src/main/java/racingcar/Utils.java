package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {
    private static final String MESSAGE_TO_INQUIRE_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static String getCarNamesWithCommaSeparated() {
        System.out.println(MESSAGE_TO_INQUIRE_CARS_NAME);
        return Console.readLine();
    }

    public static List<String> splitToListBySeparator(String str) {
        return Arrays
                .stream(str.split(","))
                .map(String::strip)
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());
    }
}
