package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            moveCarsRandomly();
        }
    }

    private void moveCarsRandomly() {
        for (Car car : cars) {
            moveCarRandomly(car);
            ResultView.printCarPosition(car);
        }
        ResultView.printLineBreak();
    }

    private void moveCarRandomly(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.moveForward();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
