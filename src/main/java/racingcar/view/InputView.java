package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String[] readCarNames() {
        String names = readLine();
        String[] carNames = new String[]{};
        try {
            carNames = names.split(",");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return carNames;
    }

    public static int readRacingTryCount() {
        String count = readLine();
        validateNumber(count);
        return Integer.parseInt(count);
    }

    private static void validateNumber(String input) {
        for (int k = 0; k < input.length(); k++) {
            if (!Character.isDigit(input.charAt(k))) {
                throw new IllegalArgumentException("숫자가 아닌 문자가 입력되었습니다.");
            }
        }
    }
}
