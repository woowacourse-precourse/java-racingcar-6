package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

public class CarList {
    public String splitCarInput(String s) {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames = Console.readLine();
            String[] names = carNames.split(",");
            boolean isValid = true;
            for (String name : names) {
                if (name.length() > 5) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return carNames;
            } else {
                System.out.println("자동차 이름은 5자 이하로 작성해주세요.");
            }
        }
    }
}
