package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView;
    private final List<Car> cars = new ArrayList<>();

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputView.setInputNames();
        System.out.println("시도할 회수는 몇회인가요?");
        inputView.setNumberOfAttempts();

        for (String name : inputView.getInputNames()) {
            Car car = new Car(name);
            cars.add(car);
        }

        int count = 0;
        while (count < inputView.getNumberOfAttempts()) {
            for (Car car : cars) {
                int number = RandomNumberGenerator.createRandomNumber();
                if (number >= 4) {
                    car.move();
                }
            }
            count++;
        }
    }
}
