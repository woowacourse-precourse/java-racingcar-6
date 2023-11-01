package racingcar;

import java.util.List;

public class Race {

    private final List<Car> cars;
    private final int count;

    Computer computer = new Computer();

    public Race() {
        this.cars = null;
        this.count = 0;
    }

    public Race(String carNames, int count) {
        this.cars = computer.createCars(carNames);
        this.count = count;
    }

    public Race start() {
        String carNames = computer.getInputCarNames();
        int cnt = computer.getInputRaceCount();

        return new Race(carNames, cnt);
    }


}
