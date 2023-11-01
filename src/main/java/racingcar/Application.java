package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

class Cars {
    public static Map<String, Integer> raceCars = new HashMap<>();

    public static void addCars(String[] inputCarNames) {
        for (String carName: inputCarNames) {
            raceCars.put(carName, 0);
        }
    }
}


public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputCarNames = Console.readLine().split(",");
        Cars.addCars(inputCarNames);


    }
}
