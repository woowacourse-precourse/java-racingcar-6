package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

class Utils {
    public static List<String> parseInput(String input) {
        String[] splitInput = input.split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : splitInput) {
            if(name.length() > 5)
                throw new IllegalArgumentException();
            carNames.add(name);
        }
        return carNames;
    }  
}

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCar = Console.readLine();
        List<String> carNames = Utils.parseInput(inputCar);
    }
}
