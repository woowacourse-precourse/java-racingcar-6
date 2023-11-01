package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = validateName(name);
        this.position = 0;
    }

    private String validateName(String name) {
        try {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 최대 5글자까지 가능합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.exit(0);
        }
        return name;
    }

    public void move() {
        final int MOVING_FORWARD = 4;

        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= MOVING_FORWARD) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}

public class Application {
    private static final int MOVING_FORWARD = 4;

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        System.out.println("시도할 회수는 몇회인가요? ");
        int tryCount = Integer.parseInt(Console.readLine());

        System.out.print("\n실행 결과\n");
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }

        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        if (winners.size() > 1) {
            System.out.print("최종 우승자: ");
            for (int i = 0; i < winners.size(); i++) {
                if (i == winners.size() - 1) {
                    System.out.print(winners.get(i));
                } else {
                    System.out.print(winners.get(i) + ", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("최종 우승자 : " + winners.get(0));
        }

    }
}
