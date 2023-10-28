package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Play {
    public void play () {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarName();

    }

    //자동차의 이름을 입력받는 기능
    public void inputCarName () {
        String cars = Console.readLine();
        List carList = new ArrayList<>();
        for (String s : cars.split(",")) {
            exception(s);
            carList.add(s);
        }
    }

    //자동차의 이름 체크
    public void exception (String cars) {
        if (!cars.matches("^[a-zA-Z,]+$")) {
            throw new IllegalArgumentException("영문자로 입력하여 주세요.");
        }
    }
}
