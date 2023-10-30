package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Car[] cars = generateCars();
        System.out.println("시도할 회수는 몇회인가요?");
        int turnCount = inputTurnCount();

        showProcessingBoard(cars, turnCount);
        showResultBoard(cars);
    }

    private static void showProcessingBoard(Car[] cars, int turnCount) {
        System.out.println();
        System.out.println("실행 결과");

        for (int turn = 0; turn < turnCount; turn++) {
            moveCars(cars);
            printCars(cars);
        }
    }

    private static void showResultBoard(Car[] cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.distance);
        }

        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.distance == maxDistance) {
                winnerNames.add(car.name);
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }

    private static void moveCars(Car[] cars) {
        for (Car car : cars) {
            int randomNumber = pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    private static void printCars(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    private static int inputTurnCount() {
        String turnCountInput = readLine();
        return Integer.parseInt(turnCountInput);
    }

    private static Car[] generateCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = readLine();

        String[] carNames = carNamesInput.split(",");
        int carCount = carNames.length;

        Car[] cars = new Car[carCount];
        for (int index = 0; index < carCount; index++) {
            cars[index] = new Car(carNames[index], 0);
        }
        return cars;
    }
}
