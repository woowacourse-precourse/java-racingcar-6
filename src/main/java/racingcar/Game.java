package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private static final int MOVING_THRESHOLD = 4;

    public static int generateRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void moveCarIfPossible(Car car, int randomValue) {
        if (randomValue >= MOVING_THRESHOLD) {
            car.move();
        }
    }

    public static void playGame(List<Car> cars, int attempts) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                moveCarIfPossible(car, generateRandomValue());
            }
            printRoundResult(cars);
        }
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder carPosition = new StringBuilder(car.getName()).append(" : ");
            for (int i = 0; i < car.getPosition(); i++) {
                carPosition.append("-");
            }
            System.out.println(carPosition.toString());
        }
        System.out.println();
    }

    public static int findWinningPosition(List<Car> cars) {
        int winningPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > winningPosition) {
                winningPosition = car.getPosition();
            }
        }
        return winningPosition;
    }

    public static List<String> findWinners(List<Car> cars, int winningPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == winningPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자: " + winnerNames);
    }


}
