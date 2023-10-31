package racingcar.domain;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int trialNum;
    private int trialCnt;

    public Race(List<Car> cars, int trialNum) {
        this.cars = cars;
        this.trialNum = trialNum;
        this.trialCnt = 0;
    }


}
