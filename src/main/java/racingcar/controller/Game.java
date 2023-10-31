package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        String[] names = inputNames.split(",");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
