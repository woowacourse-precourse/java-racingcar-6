package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public void start() {
        String inputNames = InputView.inputNames();
        String[] names = inputNames.split(",");
        for (String name : names) {
            if (name.isBlank() || name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }

        String inputAttemptCount = InputView.inputAttemptCount();
        int attemptCount;
        try {
            attemptCount = Integer.parseInt(inputAttemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 0회 이상만 가능합니다.");
        }

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }

        OutputView.printRaceStart();
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            for (Car car : cars) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.moveForward();
                }
            }
            OutputView.printCars(cars);
        }

        int maximumForwardCount = 0;
        for (Car car : cars) {
            int forwardCount = car.getForwardCount();
            maximumForwardCount = Math.max(forwardCount, maximumForwardCount);
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            int forwardCount = car.getForwardCount();
            if (forwardCount == maximumForwardCount) {
                String name = car.getName();
                winners.add(name);
            }
        }
        OutputView.printWinners(winners);
        InputView.close();
    }
}
