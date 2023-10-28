package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {
    private static final String MESSAGE_TO_INQUIRE_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_TO_INQUIRE_HOW_MANY_TRIES = "시도할 회수는 몇회인가요?";

    private static final Pattern INTEGER_PATTERN = Pattern.compile("^-?\\d+$");
    private static final String ERROR_NOT_INTEGER = "정수를 입력해주세요.";
    private static final String ERROR_LESS_THAN_ONE = "0보다 큰 값을 입력해야합니다.";

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

    public static int getHowManyTries() throws IllegalArgumentException{
        System.out.println(MESSAGE_TO_INQUIRE_HOW_MANY_TRIES);

        String userInput = Console.readLine();
        if (!isInteger(userInput)) throw new IllegalArgumentException(ERROR_NOT_INTEGER);

        int howManyTries = Integer.parseInt(userInput);
        if (howManyTries < 0) throw new IllegalArgumentException(ERROR_LESS_THAN_ONE);

        return howManyTries;
    }

    public static boolean isInteger(String str) {
        Matcher matcher = INTEGER_PATTERN.matcher(str);
        return matcher.matches();
    }
}
