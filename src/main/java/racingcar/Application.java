package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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

        race(cars, times);

    }

    public static void race(List<Car> cars, int times) {
        for (int i = 0; i < times; i++) {
            for (Car car : cars) {
                int num = getRandomNum();
                forwardOrStop(car, num);
            }
            showResult(cars);
        }
    }

    public static void showResult(List<Car> cars) {
        String dash = "-";
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + dash.repeat(car.getMove()));
        }
    }

    public static void forwardOrStop(Car car, int num) {
        if (num >= 4) {
            car.forward();
        }
    }

    public static int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
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
