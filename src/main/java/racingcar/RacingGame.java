package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingGame {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    public static void playRacingGame() {
        List<Car> cars = InputCarName.getInputCarNames();
        int numOfAttempts = InputNumOfAttempts.getNumOfAttempts();

        for (int i = 0; i < numOfAttempts; i++) {
            race(cars);
            displayResults(cars);
        }

        RaceResult.findWinner(cars);
    }

    public static int getRandomNumber() {
        int moveValue = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        return moveValue;
    }

    private static void race(List<Car> cars) {
        for (Car car : cars) {
            car.move(getRandomNumber());
        }
    }

    private static void displayResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + generatePositionString(car.getPosition()));
        }
        System.out.println();
    }

    private static String generatePositionString(int position) {
        StringBuilder positionString = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionString.append("-");
        }
        return positionString.toString();
    }

}
