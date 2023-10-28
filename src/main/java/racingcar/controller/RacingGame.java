package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.util.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String round = Console.readLine();

        InputValidator.isValidCarNames(input);
        InputValidator.isValidRound(round);

        System.out.println();

        List<Car> cars = createCars(input);
    }

    private List<Car> createCars(String input) {
        List<Car> cars = new ArrayList<>();
        for (int carIndex = 0; carIndex < input.split(",").length; carIndex++) {
            Car car = new Car(input.split(",")[carIndex]);

            cars.add(car);
        }

        return cars;
    }
}
