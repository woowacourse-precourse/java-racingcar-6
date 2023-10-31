package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("Name should be less than 5 characters.");
        this.name = name;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

class Race {
    private List<Car> cars;
    private int rounds;

    public Race(String names, int rounds) {
        this.cars = Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        this.rounds = rounds;
    }

    public void start() {
        for (int i = 0; i < rounds; i++) {
            moveCars();
            printRound();
        }
        printWinner();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printRound() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void printWinner() {
        int maxPosition = getMaxPosition();
        String winners = getWinners(maxPosition);
        System.out.println("최종 우승자 : " + winners);
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }

    private String getWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = Integer.parseInt(Console.readLine());
        Race race = new Race(names, rounds);
        race.start();
    }
}
