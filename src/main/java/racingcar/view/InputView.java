package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = Console.readLine();
        validateBlank(str);
        return str;
    }

    private static void validateBlank(String str) {
        if(str.isEmpty()) {
            throw new IllegalArgumentException("값은 빈칸이면 안됩니다");
        }
    }

    public static int askTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return stringToInt(Console.readLine());
    }

    private static int stringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 입력되어야 합니다.");
        }
    }

}
