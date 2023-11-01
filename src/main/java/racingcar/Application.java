package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars;
        int numberOfTries;

        cars = initCars();
        numberOfTries = initNumberOfTries();

        start(cars, numberOfTries);
    }
    private static List<Car> initCars() {

    }
    private static int initNumberOfTries()
    {

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
