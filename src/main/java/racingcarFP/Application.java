package racingcarFP;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {
        try {
            startRacing();
        } catch (Exception e) {
            System.err.println("잘못된 입력입니다");
        }
    }

    private static void startRacing() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = getCarNames();

        System.out.println("시도할 회수는 몇회인가요?");
        int tries = getNumberOfTries();

        System.out.println("실행 결과");
        List<Car> carList = carNames.stream().map(Car::new).collect(Collectors.toList());
        IntStream.range(0, tries).forEach(i -> {
            moveCars(carList);
            printCarDistances(carList);
        });

        List<String> winners = findWinners(carList);
        printWinners(winners);
    }

    private static List<String> getCarNames() {
        return Arrays.stream(Console.readLine().split(","))
                .peek(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("차의 이름이 5 초과입니다");
                    }
                }).collect(Collectors.toList());
    }

    private static int getNumberOfTries() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수를 입력받아 변환하는 중 문제가 생겼습니다.");
        }
    }

    private static void moveCars(List<Car> cars) {
        cars.forEach(car -> {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.distance++;
            }
        });
    }

    private static void printCarDistances(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(car.name + " : " + "-".repeat(car.distance));
        });
        System.out.println();
    }

    private static List<String> findWinners(List<Car> cars) {
        int maxDistance = cars.stream().mapToInt(car -> car.distance).max().orElse(-1);
        return cars.stream()
                .filter(car -> car.distance == maxDistance)
                .map(car -> car.name)
                .collect(Collectors.toList());
    }

    private static void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }

    private static class Car {
        final String name;
        int distance;

        Car(String name) {
            this.name = name;
            this.distance = 0;
        }
    }
}
