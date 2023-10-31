package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        String[] carNamesArray = carNamesInput.split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : carNamesArray) {
            carNames.add(name);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = Integer.parseInt(Console.readLine());

        List<Car> cars = initializeCars(carNames);

        System.out.println("\n실행 결과");
        
        for (int i = 0; i < rounds; i++) {
            moveCars(cars);
            printCarPositions(cars);
        }

        List<String> winners = findWinners(cars);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                car.moveForward();
            }
        }
    }

    private void printCarPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private List<String> findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void moveForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
