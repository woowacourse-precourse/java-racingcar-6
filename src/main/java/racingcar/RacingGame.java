package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String STARTING_PHRASE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPTING_PHRASE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_PHRASE = "실행 결과";
    private static final String WINNER_PHRASE = "최종 우승자 : ";

    static int attemptingNum;

    public void startGame() {
        System.out.println(STARTING_PHRASE);
    }

    public Car[] getInput() {
        String[] carNames = Console.readLine().split(",");
        Car[] cars = createCars(carNames);
        return cars;
    }

    public static Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i].trim());
        }
        return cars;
    }

    public static void getAttemptingNum() {
        System.out.println(ATTEMPTING_PHRASE);
        attemptingNum = Integer.parseInt(Console.readLine());
    }

    public static void moveCars(Car[] cars, int attemptingNum) {
        for (int i = 0; i < attemptingNum; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    public static void printRacingGameResults(Car[] cars) {
        System.out.println();
        System.out.println(RESULT_PHRASE);
        for (Car car : cars) {
            System.out.println(car.printResult()+"\n");
        }
    }

    public static int findMaxPosition(Car[] cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.position);
        }
        return maxPosition;
    }

    public static List<String> findWinnerNames(Car[] cars, int maxPosition) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.position == maxPosition) {
                winnerNames.add(car.name);
            }
        }
        return winnerNames;
    }

    public static void printWinnerPhrase() {
        System.out.print(WINNER_PHRASE);
    }

    public static String findWinners(Car[] cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winnerNames = findWinnerNames(cars, maxPosition);
        return String.join(", ", winnerNames);
    }
}
