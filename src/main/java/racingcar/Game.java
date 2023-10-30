package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static List<Car> cars = new ArrayList<>();
    public static Player player = new Player();

    public static void play() {
        start();
        System.out.println("\n실행 결과");
        for (int i = 0; i < player.getRaceCount(); i++) {
            race();
            printMidTermResult();
        }
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
            car.moveForward();
        }
    }

    public static void printMidTermResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getMoveForwardCount()));
        }
        System.out.println();
    }
}
