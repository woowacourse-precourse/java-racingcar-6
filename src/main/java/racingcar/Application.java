package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

class Car {
    String name;
    int moveForwardCount;

    Car(String name) {
        this.name = name;
        this.moveForwardCount = 0;
    }

    void updateCount() {
        this.moveForwardCount++;
    }

    void printExecuteResult() {
        for (int i = 0; i < this.moveForwardCount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

public class Application {
    private static final int MAX_NAME_SIZE = 5;
    private static final int MOVE_FORWARD_CONDITION_VALUE = 4;

    private static String[] inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine().replaceAll("[^a-zA-Z0-9,]", "");

        HashSet<String> carNamesSet = new HashSet<>();
        String[] carNamesArray = carNamesInput.split(",");
        for (int i = 0; i < carNamesArray.length; i++) {
            carNamesSet.add(carNamesArray[i]);

            if (carNamesArray[i].length() > MAX_NAME_SIZE) {
                throw new IllegalArgumentException();
            }
        }
        if (carNamesArray.length != carNamesSet.size()) throw new IllegalArgumentException();

        return carNamesArray;
    }

    private static int inputCount() {
        try {
            System.out.println("시도할 회수가 몇회인가요?");
            int tryCount = Integer.parseInt(Console.readLine());

            return tryCount;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    private static Car[] moveForwardAll(Car[] cars, int tryCount) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            moveForward(cars);
            printExecuteResults(cars);
        }
        return cars;
    }

    private static void moveForward(Car[] cars) {
        for (int j = 0; j < cars.length; j++) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= MOVE_FORWARD_CONDITION_VALUE) {
                cars[j].updateCount();
            }
        }
    }

    private static void printExecuteResults(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            System.out.print(cars[i].name + " : ");
            cars[i].printExecuteResult();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] carNamesArray = inputNames();
        Car[] cars = new Car[carNamesArray.length];
        for (int i = 0;  i < cars.length; i++) {
            cars[i] = new Car(carNamesArray[i]);
        }

        int tryCount = inputCount();
        cars = moveForwardAll(cars, tryCount);
    }
}
