package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;

public class Controller {
    private final List<Car> cars;

    public Controller() {
        this.cars = new ArrayList<>();
    }

    public void play() {
        String[] carNames = InputView.inputCarName();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        int attemptCount = InputView.inputAttemptCount();
        while (attemptCount-- > 0) {
            for (Car car : cars) {
                car.move();
            }
            System.out.println();
            for (Car car : cars) {
                System.out.println(car.getRecord());
            }
        }
        final int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("최종 우승자 : %s", winners.get(0).getName()));
        for (int i = 1; i < winners.size(); i++) {
            sb.append(String.format(", %s", winners.get(i).getName()));
        }
        System.out.println(sb);
    }
}
