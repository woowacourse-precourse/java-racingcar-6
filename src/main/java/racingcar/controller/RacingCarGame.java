package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;


import racingcar.model.Car;
import racingcar.view.ViewRacingGame;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<Car> cars = new ArrayList<>();
    private ViewRacingGame view;
    private int rounds;

    public RacingCarGame() {
        this.view = new ViewRacingGame();
    }

    public void createCars(String inputNames) {
        String[] carNames = inputNames.split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            cars.add(new Car(carName));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void startRacingCarGame() {
        promptForUserInput();
        simulateRacing();
        announceWinners();
    }

    private void promptForUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputNames = Console.readLine();
        if (inputNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
        createCars(inputNames);

        System.out.println("시도할 회수는 몇회인가요? ");
        try{
            rounds = Integer.parseInt(Console.readLine());
        } catch(IllegalArgumentException exception) {
            throw new IllegalArgumentException("올바른 시도 횟수를 입력해야 합니다.");
        }
    }

    private void simulateRacing() {
        for (int round = 1; round <= rounds; round++) {
            moveCars();
            for (Car car : cars) {
                view.printCarStatus(car);
            }
        }
    }

    private void announceWinners() {
        List<String> winners = getWinners();
        view.printWinners(winners);
    }
}
