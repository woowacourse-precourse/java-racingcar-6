package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

class Cars {
    public Map<String, Integer> raceCars = new HashMap<>();

    public Cars(String[] inputCars) {
        for (String car: inputCars) {
            this.raceCars.put(car, 0);
        }
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Cars cars = new Cars(Console.readLine().split(","));
        
    }
}
