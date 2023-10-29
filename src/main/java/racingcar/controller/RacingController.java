package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView;
    private final List<Car> cars = new ArrayList<>();
    private int attemptCount = 0;
    private int maxPosition = 0;
    private String winner = "";

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        startInput();

        carsSetting();

        System.out.println();
        System.out.println("실행 결과");

        driveRepeatExecution();

        findWinners();

        System.out.println("최종 우승자 : " + winner);
    }

    private void findWinners() {
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                makeListOfWinners(car);
            }
        }
    }

    private void makeListOfWinners(Car car) {
        if (winner.isEmpty()) {
            winner = car.getName();
        } else {
            winner += ", " + car.getName();
        }
    }

    private void driveRepeatExecution() {
        while (attemptCount < inputView.getNumberOfAttempts()) {
            for (Car car : cars) {
                isMove(car);
                isMaxPostion(car);
                executionResult(car);
            }
            System.out.println();
            attemptCount++;
        }
    }

    private static void executionResult(Car car) {
        String result = car.getName() + " : " + "-".repeat(car.getPosition());
        System.out.println(result);
    }

    private void isMaxPostion(Car car) {
        maxPosition = Math.max(maxPosition, car.getPosition());
    }

    private static void isMove(Car car) {
        int number = RandomNumberGenerator.createRandomNumber();
        if (number >= 4) {
            car.move();
        }
    }

    private void carsSetting() {
        for (String name : inputView.getInputNames()) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void startInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputView.setInputNames();
        System.out.println("시도할 회수는 몇회인가요?");
        inputView.setNumberOfAttempts();
    }
}
