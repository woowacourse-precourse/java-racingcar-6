package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ResultService {
    public static void printNumberOfMovingForward(Map<Car, Integer> cars) {
        for (Car car : cars.keySet()) {
            System.out.printf("%s : ", car.getCar());
            int numberOfMovingForward = cars.get(car);
            printDashes(numberOfMovingForward);
        }
    }

    public static void printDashes(int numberOfMovingForward) {
        if (numberOfMovingForward == 0) {
            System.out.print("\n");
        } else {
            for (int i = 1; i <= numberOfMovingForward; i++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
    }

    public static void printResultStart() {
        System.out.println("실행 결과");
    }

    public static void printResultsPerGame(Map<Car, Integer> cars, int numberOfMatches) {
        for (int i = 1; i <= numberOfMatches; i++) {
            cars = recordGameResult(cars);
            printNumberOfMovingForward(cars);
            System.out.println();
        }
    }

    private static Map<Car, Integer> recordGameResult(Map<Car, Integer> cars) {
        for (Car car : cars.keySet()) {
            boolean isMovingForward = GameService.movingForwardCheck(GameService.pickRandomNumber());
            cars = GameService.recordNumberOfMovingForward(cars, car, isMovingForward);
        }
        return cars;
    }

    public static List<String> decideWinners(Map<Car, Integer> cars) {
        int maxNumberOfMovingForward = Collections.max(cars.values());
        List<String> carList = new ArrayList<>();
        for (Car car : cars.keySet()) {
            if (cars.get(car).equals(maxNumberOfMovingForward)) {
                carList.add(car.getCar());
            }
        }
        return carList;
    }

    public static void printWinners(List<String> carList) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", carList));
    }
}
