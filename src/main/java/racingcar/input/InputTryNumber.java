package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class InputTryNumber {

    public static int inputTryNumber(){

        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumber = Console.readLine();
        int number = isValidNumber(tryNumber);

        return number;
    }

    public static int isValidNumber(String tryNumber){
        try {
            int number = Integer.parseInt(tryNumber);
            validatePositiveNumber(number);

            return number;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 외의 형식을 입력했습니다.");
        }
    }

    private static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("회수를 양수로 입력해주세요.");
        }
    }
}
