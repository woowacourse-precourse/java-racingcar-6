package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Game {
    public List<String> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> cars = Arrays.asList(input.split(","));

        for (String car : cars) {
            Util.validateCarName(car);
        }

        Util.checkForDuplicates(cars);

        return cars;
    }

}
