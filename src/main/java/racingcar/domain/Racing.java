package racingcar.domain;

import java.util.List;

public class Racing {

    private static final Integer initialRound = 0;

    private List<Car> cars;
    private Integer totalRound;
    private Integer round;

    public Racing(List<Car> cars, Integer totalRound){
        this.cars = cars;
        this.totalRound = totalRound;
        this.round = initialRound;
    }

    public List<Car> getCars(){
        return cars;
    }

    public Integer getTotalRound(){
        return totalRound;
    }

    public Integer getRound(){
        return round;
    }
}
