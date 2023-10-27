package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameSimulator {

    public void startGamePlay() {
        UserInputHandler userInputHandler = new UserInputHandler();
        List<String> carNames = userInputHandler.getUserCarNames();
        long userCount = userInputHandler.getUserCount();

        // Car 객체 생성
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(Collections.singletonList(carName));
            cars.add(car);
        }

        simulateGame(cars, userCount);
    }

    public void simulateGame(List<Car> cars, long userCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < userCount; i++) {
            moveCars(cars);
            printCarStatus(cars);
        }
        printWinners(cars);
    }

    private void printCarStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    public void printWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : " + winners.get(0));
        if (winners.size() > 1) {
            for (int i = 1; i < winners.size(); i++) {
                System.out.print(", " + winners.get(i));
            }
            System.out.println();
        }


    }

}
