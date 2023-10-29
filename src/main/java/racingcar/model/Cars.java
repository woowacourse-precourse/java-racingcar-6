package racingcar.model;

import java.util.List;

public class Cars {
    private List<Car> cars;
    private int playNumbers;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int getPlayNumbers() {
        return playNumbers;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playNumberTimes(int number){
        playNumbers = number;
    }
}
