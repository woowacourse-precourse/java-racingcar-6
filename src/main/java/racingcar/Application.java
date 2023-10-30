package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Car> generateCarList() {
        String[] carNames;
        List<Car> carList = new ArrayList<>();

        carNames = inputNames();
        addCars(carList, carNames);
        return carList;
    }

    private static String[] inputNames() {
        String input = Console.readLine();

        return input.split(",");
    }

    private static void addCars(List<Car> carList, String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i], i));
        }
    }

    private static int inputCount() {
        String input = Console.readLine();

        validateInputCount(input);
        return (Integer.parseInt(input));
    }

    private static void validateInputCount(String input) {
        if (input.isEmpty() || notNumber(input)) {
            throw (new IllegalArgumentException());
        }
    }

    private static boolean notNumber(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    private static void race(List<Car> carList, int cnt) {
        for (int i = 0; i < cnt; i++) {
            moveList(carList);
            System.out.println();
        }
    }

    private static void moveList(List<Car> carList) {
        for (Car car : carList) {
            car.move();
            System.out.println(car.path());
        }
    }

    private static void printWinners(List<Car> carList) {
        Collections.sort(carList);
        System.out.print("최종 우승자 : ");
        System.out.print(Car.winnerString(carList));
    }
}
