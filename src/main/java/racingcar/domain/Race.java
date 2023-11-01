package racingcar.domain;

import java.util.List;

public class Race {

    private List<Car> cars;
    private int countOfPlays;


    public Race(List<Car> cars, int countOfPlays) {
        this.cars = cars;
        this.countOfPlays = countOfPlays;
    }

    private Race(int countOfPlays){

    }

    private Race(List<Car> cars) {

    }

    private Race() {

    }


}
