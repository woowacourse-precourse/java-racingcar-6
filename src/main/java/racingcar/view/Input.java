package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String setCarMembers() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int setRaceNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String num = Console.readLine();
        return Integer.parseInt(num);
    }
}
