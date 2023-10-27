package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {

    List<Car> cars;

    public RacingCarGame() {
        cars = new ArrayList<>();
    }

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();

        if (!carNamesInput.matches("^[^,]+(,[^,]+)*$")) {
            throw new IllegalArgumentException();
        }

        String[] carNames = carNamesInput.split(",");

        Arrays.stream(carNames).forEach(t -> {
            cars.add(Car.of(t));
        });
    }
}
