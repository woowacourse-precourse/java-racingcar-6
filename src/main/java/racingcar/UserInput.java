package racingcar;

import java.util.Scanner;

public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInputString(String prompt) {
        String input;
        do {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("입력된 값이 없습니다. 다시 입력하세요.");
            } else if (input.contains(",")) {
                System.out.println("자동차 이름에 쉼표(,)를 포함할 수 없습니다. 다시 입력하세요.");
            }
        } while (input.isEmpty() || input.contains(","));

        return input;
    }

    public static int getInputInt(String prompt, int min, int max) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < min || input > max) {
                    System.out.println("범위(" + min + "~" + max + ")를 벗어난 입력입니다. 다시 입력하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                input = min - 1;
            }
        } while (input < min || input > max);

        return input;
    }
}
