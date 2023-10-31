package racingcar;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        String[] names = readNames();
        int tryingCount = readCount();
        Car[] cars = creteCars(names);
        while (tryingCount > 0) {

            moveCars(cars);
            printDistanceStatus(cars);
            System.out.println();

            tryingCount--;
        }
        checkWinners(cars);

    }

    public static String[] readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");

        if (!isValidString(names)) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }

        return names;
    }

    public static boolean isValidString(String[] names) {
        Set<String> uniqueNames = new HashSet<>();

        if (names.length <= 1) {
            return false;
        }

        for (String name : names) {
            if (name.length() > 5) {
                return false;
            }
            if (name.isEmpty()) {
                return false;
            }
            if (!uniqueNames.add(name)) {
                return false;
            }
        }

        return true;
    }

    public static int readCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        if (!isValidNumber(input)) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
        int count = Integer.parseInt(input);
        return count;
    }

    public static boolean isValidNumber(String input) {
        if (!input.matches("\\d+")) {
            return false;
        }
        if (input.isEmpty()) {
            return false;
        }
        if (Integer.parseInt(input) < 1) {
            return false;
        }
        return true;
    }

    public static Car[] creteCars(String[] names) {
        Car[] cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }

        return cars;
    }

    public static void moveCars(Car[] cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    public static void printDistanceStatus(Car[] cars) {
        for (Car car : cars) {
            car.printDistanceStatus();
        }
    }

    public static void checkWinners(Car[] cars) {
        int maxDistance = getMaxDistance(cars);
        List<Car> winners = getWinners(cars, maxDistance);
        printWinners(winners);
    }

    private static int getMaxDistance(Car[] cars) {
        int maxDistance = 0;

        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }

        return maxDistance;
    }

    private static List<Car> getWinners(Car[] cars, int maxDistance) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }

        return winners;
    }

    private static void printWinners(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();

        for (Car winner : winners) {
            winnerNames.append(winner.getName()).append(", ");
        }
        winnerNames.setLength(winnerNames.length() - 2);

        System.out.println("최종 우승자 : " + winnerNames);
    }
}

