package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class RacingGame {

    public static void main(String[] args) {
        List<Car> cars = getCarsFromUser();
        int rounds = getRoundsFromUser();

        System.out.println("\n실행 결과");
        playRacingGame(cars, rounds);

        displayWinners(cars);
    }

    private static List<Car> getCarsFromUser() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): \n");
        String[] carNames = Console.readLine().split(",", -1);
        return generateCars(carNames);
    }

    private static int getRoundsFromUser() {
        System.out.print("시도할 회수는 몇회인가요? \n");
        int rounds = Integer.parseInt(Console.readLine());
        if (rounds <= 0) {
            throw new IllegalArgumentException("숫자는 0보다 커야함");
        }
        return rounds;
    }

    private static List<Car> generateCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        Set<String> nameSet = new HashSet<>();

        for (String name : carNames) {
            name = name.trim();
            validateCarName(name, nameSet);
            nameSet.add(name);
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void validateCarName(String name, Set<String> nameSet) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비워둘 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        if (!name.matches("^[a-z,]*[a-z]$")) {
            throw new IllegalArgumentException("자동차 이름은 문자만 가능합니다.");
        }
        if (nameSet.contains(name)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private static void playRacingGame(List<Car> cars, int rounds) {
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.displayDistance());
            }
            System.out.println();
        }
    }

    private static void displayWinners(List<Car> cars) {
        List<String> winners = getWinners(cars);
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }

    public static List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxDistance = getMaxDistance(cars);

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public static int getMaxDistance(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getDistance() > max) {
                max = car.getDistance();
            }
        }
        return max;
    }

    static class Car {
        private final String name;
        private int distance = 0;

        public Car(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getDistance() {
            return distance;
        }

        public String displayDistance() {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < distance; i++) {
                result.append("-");
            }
            return result.toString();
        }

        public void move() {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                distance++;
            }
        }
    }
}
