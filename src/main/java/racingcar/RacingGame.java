package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;

public class RacingGame {
    ArrayList<Car> carArrayList = new ArrayList<>();
    Integer count = 0;

    public void start() {
        // 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        // 몇대까지 가능하게 할 것인가?
        String[] nameList = input.split(",");
        for (String s : nameList) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
            }
            carArrayList.add(new Car(s, 0));
        }

    }
}

