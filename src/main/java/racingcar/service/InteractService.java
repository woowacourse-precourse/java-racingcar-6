package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class InteractService {

    public static String getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static Integer getTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
