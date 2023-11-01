package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputNames = Console.readLine();
            String[] carNames = inputNames.split(",");

            if (carNames.length < 2) {
                throw new IllegalArgumentException("자동차는 최소 2대 이상이어야 합니다.");
            }

            System.out.println("시도할 회수는 몇회인가요?");
            int tryCount = Integer.parseInt(Console.readLine());

            if (tryCount <= 0) {
                throw new IllegalArgumentException("시도 회수는 양의 정수여야 합니다.");
            }

            List<Car> cars = new ArrayList<>();
            for (String name : carNames) {
                cars.add(new Car(name));
            }

            for (int i = 0; i < tryCount; i++) {
                for (Car car : cars) {
                    car.move();
                }
            }

            int maxPosition = 0;
            for (Car car : cars) {
                maxPosition = Math.max(maxPosition, car.getPosition());
            }

            System.out.println("실행 결과");
            for (Car car : cars) {
                System.out.println(car.getName() + " : " + car.printPosition());
            }

            System.out.println("최종 우승자: ");
            List<String> winners = new ArrayList<>();
            for (Car car : cars) {
                if (car.getPosition() == maxPosition) {
                    winners.add(car.getName());
                }
            }
            System.out.println(String.join(", ", winners));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String printPosition() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
