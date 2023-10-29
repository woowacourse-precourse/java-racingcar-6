package racingcar.global.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String stringInput() {
         String input = Console.readLine();
         if(input.isEmpty()) {
             throw new IllegalArgumentException("Input cannot be null");
         }
         return input;
    }

    public static Integer IntegerInput() {
        String input = Console.readLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자가 아닌 숫자를 입력해주세요");
        }
    }
}
