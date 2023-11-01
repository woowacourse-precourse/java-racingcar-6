package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        List<Car> cars;
        int numberOfTries;

        cars = initCars();
        numberOfTries = initNumberOfTries();

        start(cars, numberOfTries);
    }
    private static List<Car> initCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        String carNames = Console.readLine();
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
    private static int initNumberOfTries()
    {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
    private static void start(List<Car> cars, int numberOfTries) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfTries; i++) {
            moveCars(cars);
            printCars(cars);
        }
        announceWinner(cars);
    }
    private static void moveCars(List<Car> cars) {

    }

    private static void printCars(List<Car> cars) {

    }

    private static void announceWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
    }

    private static int getMaxPosition(List<Car> cars) {

    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position++;
    }

    public String printPosition() {
        return "-".repeat(this.position);
    }
}
