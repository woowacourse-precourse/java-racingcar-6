package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int RANDOM_MIN = 0;
    public static final int RANDOM_MAX = 9;
    private static final int RANDOM_THRESHOLD = 4;
    static List<Car> racingCar;

    public static void run() {
        racingCar = Car.initialize();
        int iterationNumber = User.inputMoveCount();

        Car.checkLength(racingCar);

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < iterationNumber; i++) {
            printRacing(updateStatus(racingCar));
        }
        printWinner(findWinner(racingCar));
    }

    public static int randomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }

    public static boolean checkRandomNumber(int randomNumber) {
        return randomNumber >= RANDOM_THRESHOLD;
    }

    private static List<Car> updateStatus(List<Car> racingCar) {
        for (Car car : racingCar) {
            if (checkRandomNumber(randomNumber())) {
                int moveCount = car.getMoveCount();
                car.setMoveCount(moveCount + 1);
            }
        }
        return racingCar;
    }

    private static void printRacing(List<Car> racingCar) {
        for (Car car : racingCar) {
            String dashes = "-".repeat(car.getMoveCount());
            System.out.println(car + " : " + dashes);
        }
        System.out.println();
    }

    public static List<String> findWinner(List<Car> racingCar) {
        int max = 0;
        List<String> winner = new ArrayList<>();
        for (Car car : racingCar) {
            int value = car.getMoveCount();
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

    public static void printWinner(List<String> winner) {
        System.out.print("최종 우승자 : ");
        if (!winner.isEmpty()) {
            System.out.print(winner.get(0));
            for (int i = 1; i < winner.size(); i++) {
                System.out.print(", " + winner.get(i));
            }
        }
    }
}