package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Play {
    public void play () {
        inputCarName();
        inputNumber();
    }

    //자동차의 이름을 입력받는 기능
    public void inputCarName () {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        List carList = new ArrayList<>();

        for (String s : cars.split(",")) {
            carNameCheck(s);
            carList.add(s);
        }
    }

    //시도할 횟수를 입력받는 기능
    public int inputNumber () {
        System.out.println("시도할 회수는 몇회인가요?");
        String number = Console.readLine();
        numberCheck(number);

        return Integer.parseInt(number);
    }

    //자동차의 이름 체크
    public void carNameCheck (String cars) {
        if (!cars.matches("^[a-zA-Z,]+$")) {
            throw new IllegalArgumentException("영문자로 입력하여 주세요.");
        }
    }

    //횟수 체크
    public void numberCheck (String number) {
        if (!number.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자만 입력하여 주세요.");
        }
    }
}
