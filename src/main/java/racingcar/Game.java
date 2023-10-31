package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Game {
    public String[] inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameAll = Console.readLine();

        if (carNameAll.isEmpty()){
            throw new IllegalArgumentException();
        }

        return carNameAll.split(",");
    }
}
