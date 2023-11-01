package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = inputCarNames(scanner);

    }
    private static List<Car> inputCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
    static class Car {
        private String name;
        private int position;

        public Car(String name) {
            this.name = name;
            this.position = 0;
        }


    }
}