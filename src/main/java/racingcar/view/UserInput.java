package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static String inputCarName() {
        System.out.println("경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
    }
    public static int inputMovementNumber(){
        System.out.println("이동할 횟수를 입력하세요");
        String time = Console.readLine();
        int number = Integer.parseInt(time);
        return number;
    }
}
