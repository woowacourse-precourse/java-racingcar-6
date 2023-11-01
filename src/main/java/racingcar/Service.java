package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Service {
    static String[] getCarNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    static int getTryCountFromUser() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 회수는 숫자로 입력해주세요.");
        }
    }

    static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(name));
        }
        return cars;
    }

    static void raceCars(List<Car> cars, int tryCount) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            printCurrentPositions(cars);
        }

        List<String> winners = determineWinners(cars);
        printWinners(winners);
    }

    private static void printCurrentPositions(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder currentPosition = new StringBuilder();
            for (int j = 0; j < car.getPosition(); j++) {
                currentPosition.append("-");
            }
            System.out.println(car.getName() + " : " + currentPosition);
        }
        System.out.println();
    }

    private static List<String> determineWinners(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}