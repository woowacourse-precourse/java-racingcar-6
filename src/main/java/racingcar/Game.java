package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Game {
    static List<Car> racingCar;

    public static void racingGame() {
        racingCar = Car.carReset();
        int iterationNumber = User.stringToInteger();
        Car.checkLength(racingCar);

        for (int i = 0; i < iterationNumber; i++) {
            printRacing(updateCarStats(racingCar));
        }
        printWinner(findWinner(racingCar));
    }

    private static int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static boolean checkNumber(int randomNumber) {
        return randomNumber >= 4;
    }

    private static List<Car> updateCarStats(List<Car> racingCar) {
        for (Car car : racingCar) {
            if (checkNumber(randomNumber())) {
                int count = car.getCount();
                car.setCount(count + 1);
            }
        }
        return racingCar;
    }

    private static void printRacing(List<Car> racingCar) {
        for (Car car : racingCar) {
            String dashes = "-".repeat(car.getCount());
            System.out.println(car + " : " + dashes);
        }
        System.out.println();
    }

    private static List<String> findWinner(List<Car> racingCar) {
        int max = 0;
        List<String> winner = new ArrayList<>();
        for (Car car : racingCar) {
            int value = car.getCount();
            if (value > max) {
                max = value;
                winner.clear();
                winner.add(car.getName());
            } else if (value == max) {
                winner.add(car.getName());
            }
        }
        return winner;
    }

    private static void printWinner(List<String> winner) {
        System.out.print("최종 우승자 : ");
        if (!winner.isEmpty()) {
            System.out.print(winner.get(0));
            for (int i = 1; i < winner.size(); i++) {
                System.out.print(", " + winner.get(i));
            }
        }
        System.out.println();
    }
}