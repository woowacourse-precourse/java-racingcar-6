package racingcar.User;

import camp.nextstep.edu.missionutils.Console;

public class UserInputReciver {
    public static String carNameByUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        return carName;
    }

    public static int turnCountByUserInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        int turnCount = Integer.parseInt(Console.readLine());
        return turnCount;
    }
}
