package racingcar.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Count {
    public static final int MIN_COUNT = 1;

    public static String inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();
        return input;
    }
    public static int raceCount(String input) {
        checkExeption(input);
        int count = Integer.parseInt(input);
        return count;
    }
    private static void checkExeption(String input) {
        checkIsPositive(input);
        checkEmpty(input);
        checkIsInteger(input);
    }
    private static void checkIsPositive(String count) {
        if (Integer.parseInt(count) < MIN_COUNT) {
            throw new IllegalArgumentException();
        }
    }
    private static void checkEmpty(String count) {
        if (count.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
    private static void checkIsInteger(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
