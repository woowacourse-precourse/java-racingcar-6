package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputTryNumber {

    public static int inputTryNumber(){
        System.out.println("시도할 회수는 몇회인가요?");

        while (true) {
            try {
                String tryNumber = Console.readLine();
                int number = isValidNumber(tryNumber);

                return number;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int isValidNumber(String tryNumber){
        try {
            int number = Integer.parseInt(tryNumber);
            validatePositiveNumber(number);

            return number;

        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 외의 형식을 입력했습니다.");
        }
    }

    private static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
