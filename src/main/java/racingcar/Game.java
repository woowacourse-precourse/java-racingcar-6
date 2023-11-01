package racingcar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
    public static void runGame(ArrayList<Car> cars, int counts) {
        for (int i = 0; i < counts; i++) {
            for (Car car : cars) {
                car.move();
            }
            printResult(cars);
            System.out.println();
        }
    }

    public static void printResult(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.name + " : ");
            for (int i = 0; i < car.position; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static ArrayList<String> getWinner(ArrayList<Car> cars) {
        ArrayList<String> winners = new ArrayList<String>();
        int maxPosition = getMaxPosition(cars);
        for (Car car : cars) {
            if (car.position == maxPosition) {
                winners.add(car.name);
            }
        }
        return winners;
    }

    public static int getMaxPosition(ArrayList<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.position > maxPosition) {
                maxPosition = car.position;
            }
        }
        return maxPosition;
    }

}
