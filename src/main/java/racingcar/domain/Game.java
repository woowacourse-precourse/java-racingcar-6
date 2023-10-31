package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public static List<Car> cars = new ArrayList<>();
    public static Player player = new Player();
    public static List<String> winners = new ArrayList<>();

    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;

    public static void play() {
        start();
        System.out.println("\n실행 결과");
        for (int i = 0; i < player.getRaceCount(); i++) {
            race();
            printMidTermResult();
        }
        result();
        printResult();
    }

    public static void start() {
        askCarNames();
        nameCars();
        askRaceCount();
    }

    public static void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        player.inputCarNames();
    }

    public static void nameCars() {
        List<String> carNames = player.getCarNames();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public static void askRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        player.inputRaceCount();
    }

    public static void race() {
        for (Car car : cars) {
            car.moveForward(getRandomNumber());
        }
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
    }

    public static void printMidTermResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getMoveForwardCount()));
        }
        System.out.println();
    }

    public static void result() {
        int maxMoveForwardCount = findMaxMoveForwardCount();
        for (Car car : cars) {
            if (car.getMoveForwardCount() == maxMoveForwardCount) {
                winners.add(car.getName());
            }
        }
    }

    public static int findMaxMoveForwardCount() {
        int maxMoveForwardCount = 0;
        for (Car car : cars) {
            int moveForwardCount = car.getMoveForwardCount();
            if (moveForwardCount > maxMoveForwardCount) {
                maxMoveForwardCount = moveForwardCount;
            }
        }

        return maxMoveForwardCount;
    }

    public static void printResult() {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
