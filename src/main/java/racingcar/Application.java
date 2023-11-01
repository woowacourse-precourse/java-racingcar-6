package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    private List<Car> cars = new ArrayList<>();
    private int tryNumber;

    public static void main(String[] args) {
        Application game = new Application();
        game.getName();
    }

    public void getName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        StringTokenizer tokenizer = new StringTokenizer(carNamesInput, ",");

        while (tokenizer.hasMoreTokens()) {
            String carName = tokenizer.nextToken().trim();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(carName));
        }

        getTry();
    }

    public void getTry() {
        System.out.println("시도할 횟수는 몇회인가요?");
        tryNumber = Integer.parseInt(Console.readLine());
        if (tryNumber < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
        }

        racing();
    }

    public void racing() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            for (Car car : cars) {
                car.move();
            }
            printCarStatus();
        }
        determineWinners();
    }

    public void printCarStatus() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionString());
        }
        System.out.println();
    }

    public void determineWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionString() {
        return "-".repeat(position);
    }
}