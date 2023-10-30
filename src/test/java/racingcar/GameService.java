package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameService {
    private static final String ErrorMessage = "0보다 큰 숫자를 입력해주세요.";
    public static String getUserInputForCars() {
        return readLine();
    }

    public static int getUserInputForNumberOfMatches() {
        try {
            int number = Integer.parseInt(readLine());
            return validateNumber(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage);
        }
    }

    private static int validateNumber(int number) {
        if (number > 0) {
            return number;
        }
        throw new IllegalArgumentException(ErrorMessage);
    }


}
