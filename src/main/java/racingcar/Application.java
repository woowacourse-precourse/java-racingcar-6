package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNamesInput = Console.readLine("자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분): ");
        List<String> carNames = List.of(carNamesInput.split(","));

        int attempts = Integer.parseInt(Console.readLine("시도할 회수를 입력하세요: "));

        List<Car> cars = createCars(carNames);


    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }


}