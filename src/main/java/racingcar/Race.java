package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void start() {
        ResultView.printLineBreak();
        ResultView.printResultNotification();
        for (int i = 0; i < rounds; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            moveCar(car);
            ResultView.printCarPosition(car);
        }
        ResultView.printLineBreak();
    }

    private void moveCar(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.moveForward();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
