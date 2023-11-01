package racingcar;

import java.util.List;

public class Race {
    private List<Car> cars;
    private int totalTrys;

    public Race(List<Car> cars, int totalTrys) {
        this.cars = cars;
        this.totalTrys = totalTrys;
    }

    public void excuteRace() {

    }

    public List<Car> getRaceResult() {
        return cars;
    }
}
