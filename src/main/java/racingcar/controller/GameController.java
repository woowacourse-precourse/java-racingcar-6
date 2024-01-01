package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.ConsoleView;

public class GameController {

    public void run() {
        List<Car> cars = initializeCars();
        int tryCount = getTryCount();
        simulateRace(cars, tryCount);
        List<String> winners = findWinners(cars);
        ConsoleView.printWinners(winners);
    }

    private List<Car> initializeCars() {
        ConsoleView.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        validateCarNames(carNames);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
            }
        }
    }

    private int getTryCount() {
        ConsoleView.printMessage("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private void simulateRace(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            ConsoleView.printRaceStatus(cars);
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    private List<String> findWinners(List<Car> cars) {
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
