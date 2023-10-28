package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        List<Car> cars = createCars(inputCarNames);
    }

    public List<Car> createCars(String inputCarNames) {
        String[] split = inputCarNames.split(",");
        return Arrays.stream(split)
                .map(inputCarName -> new Car(inputCarName))
                .collect(Collectors.toList());
    }
}
