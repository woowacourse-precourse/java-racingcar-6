package racingcar;

import camp.nextstep.edu.missionutils.Console;

public final class Reader {

    private Reader() {
        throw new UnsupportedOperationException();
    }

    public static String[] carNames() {
        return Console.readLine().split(",");
    }

    public static Integer attempts() {
        String inputAttempts = Console.readLine();
        return validInputAttempts(inputAttempts);
    }

    private static Integer validInputAttempts(String inputAttempts) {
        try {
            return Integer.parseInt(inputAttempts);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

}
