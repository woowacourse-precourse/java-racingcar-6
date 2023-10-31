package racingcar.view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {
    public static String nameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static Integer numberInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        String stringNum = Console.readLine();
        int number = stringToInt(stringNum);
        validnum(number);
        return number;
    }

    private static void validnum(int number) {
        if (number<1){
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
        }
    }

    private static int stringToInt(String stringNum) {
        try {
            return Integer.parseInt(stringNum);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 합니다.");
        }
    }

}
