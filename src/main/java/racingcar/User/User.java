package racingcar.User;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public static String carNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        return carName;
    }

    public static int turnNumInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        int turnNum = Integer.parseInt(Console.readLine());
        return turnNum;
    }
}
