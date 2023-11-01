package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        RacingController controller = new RacingController();
        controller.start();
    }
}

class RacingController {

    public void start() {
        RacingView view = new RacingView();
        String carNamesInput = view.getInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = initializeCars(carNamesInput.split(","));
        
        int rounds = Integer.parseInt(view.getInput("시도할 회수는 몇회인가요?"));
        
        view.printMessage("\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            moveCars(cars);
            view.printCarPositions(cars);
        }
        
        List<String> winners = findWinners(cars);
        view.printMessage("최종 우승자 : " + String.join(", ", winners));
    }

    private List<Car> initializeCars(String[] carNames) {
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

class RacingView {

    public String getInput(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printCarPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
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
