package racingcar;

import camp.nextstep.edu.missionutils.Console;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = setupCars();
        int moves = getNumberOfMoves();

        startRacing(cars, moves);
        displayWinners(cars);

    }
    private static List<Car> setupCars() {
        System.out.println("자동차 이름을 입력하세요(이름은 쉼표(,)로 구분, 5자 이하): ");
        String[] carNames = Console.readLine().split(",");
        validateCarNames(carNames);

        return createCars(carNames);
    }

    private static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static int getNumberOfMoves() {
        System.out.println("몇 번의 이동을 할 것인지 입력하세요: ");
        try {
            int moves = Integer.parseInt(Console.readLine());
            if (moves < 0) {
                throw new IllegalArgumentException("이동 횟수는 0 이상이어야 합니다.");
            }
            return moves;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 값을 입력해주세요.");
        }
    }

    private static void startRacing(List<Car> cars, int moves) {
        System.out.println("경주 시작!");
        for (int i = 0; i < moves; i++) {
            moveCars(cars);
            displayCarPositions(cars);
        }
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    private static void displayCarPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.name + " : " + new String(new char[car.distance]).replace('\0', '-'));
        }
        System.out.println();
    }

    private static void displayWinners(List<Car> cars) {
        System.out.println("최종 우승자 : " + getWinners(cars));
    }

    private static String getWinners(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);
        return getCarNamesWithDistance(cars, maxDistance);
    }

    private static int getMaxDistance(List<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.distance);
        }
        return maxDistance;
    }

    private static String getCarNamesWithDistance(List<Car> cars, int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.distance == maxDistance) {
                winners.add(car.name);
            }
        }
        return String.join(", ", winners);
    }
}








