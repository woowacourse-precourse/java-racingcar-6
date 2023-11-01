package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

class RacingGame {
    public List<Car> getCarsFromInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(name));
        }
        return cars;
    }

    public int getRoundsFromInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void start() {
        List<Car> cars = getCarsFromInput();
        int rounds = getRoundsFromInput();

        System.out.println("\\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car);
            }
            System.out.println();
        }

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

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.start();
    }
}
