package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {
    List<Car> racingCars;
    int moveCount;

    public RacingCarGame() {
        this.racingCars = makeCars();
        this.moveCount = readMoveCount();
    }

    private List<Car> makeCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<Car> cars = new ArrayList<>();

        List<String> names = readCarNames();
        names.forEach(name -> cars.add(new Car(name.trim())));

        return cars;
    }

    // 기능 1) 5자 이하의 자동차 이름 n개를 쉼표(,)를 기준으로 구분하여 입력 받는다.
    private List<String> readCarNames() {
        return Arrays.stream(Console.readLine().split(",")).toList();
    }

    // 기능 2) 몇 번의 이동을 할 것인지 입력 받는다.
    private int readMoveCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
