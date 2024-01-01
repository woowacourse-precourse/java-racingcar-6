package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
            }
        }


        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move(Randoms.pickNumberInRange(0, 9));
            }
            printRaceStatus(cars);
        }

        List<String> winners = findWinners(cars);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionString());
        }
        System.out.println();
    }

    private static List<String> findWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        if (number >= 4) {
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
