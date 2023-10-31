package racingcar;

import camp.nextstep.edu.missionutils.Console;


public class Cars {

    public String[] carNamingAndException() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String name = Console.readLine();
        String[] names = (name.split(","));
        //5글자 이하로 입력 받도록 예외 처리
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() > 5) {
                throw new IllegalArgumentException("5글자 이하로 입력하세요");
            }
        }

        return names;
    }
}


