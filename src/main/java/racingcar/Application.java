package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

class Car {
    private String name;
    private Integer move;

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public void forward() {
        this.move += 1;
    }

    public String getName() {
        return name;
    }

    public Integer getMove() {
        return move;
    }
}

public class Application {
    public static void main(String[] args) {

        List<Car> cars = getCars();

        int times = getTimesToMove();
    }

    public static int getTimesToMove() {
        String input = Console.readLine();
        return validNum(input);
    }

    public static int validNum(String input) {
        boolean matches = input.matches("^[0-9]+$");

        if (!matches) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    public static List<Car> getCars() {

        List<Car> cars = new ArrayList<>();

        String[] names = Console.readLine().split(",");

        for (String name : names) {
            checkNameLength(name);
            cars.add(new Car(name));
        }

        return cars;
    }

    private static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
