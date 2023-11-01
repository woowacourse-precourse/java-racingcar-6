package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static String[] getCarNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
        String input = Console.readLine();
        return input.split(",");
    }

    public static int getRaceRounds() {
        System.out.print("시도할 회수는 몇회인가요?: ");
        return Integer.parseInt(Console.readLine());
    }
}