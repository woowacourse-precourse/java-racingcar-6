package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
            cars.add(new Car(name));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int attempts = Integer.parseInt(Console.readLine());

        List<Integer> randomNumbers = generateRandomNumbers(attempts);

        for (int i = 0; i < attempts; i++) {
            System.out.println("시도 " + (i + 1) + ":");
            for (int j = 0; j < cars.size(); j++) {
                Car car = cars.get(j);
                int number = randomNumbers.get(i);
                car.move(number);
                System.out.println(car);
            }
        }

        List<String> winners = getWinners(cars);
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));

    }

    static List<String> getWinners(List<Car> cars) {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            int distance = car.getDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(car.getName());
            } else if (distance == maxDistance) {
                winners.add(car.getName());
            }
        }

        return winners;
    }


    static List<Integer> generateRandomNumbers(int attempts) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < attempts; i++) {
            randomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }
        return randomNumbers;
    }
}

class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int number) {
        if (number >= 4) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " : ");
        for (int i = 0; i < distance; i++) {
            sb.append(distance > 0 ? "-" : ""); // 대시 출력을 조정
        }
        return sb.toString();
    }
}
