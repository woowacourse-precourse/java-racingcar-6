package racingcar.service;

import racingcar.domain.RaceResult;
import racingcar.domain.Car;
import racingcar.util.Util;

import java.util.ArrayList;

public class RacingReferee {
    // 레이싱 게임을 실행에 대한 책임을 다하는 심판
    private final ArrayList<Car> cars;
    private final int CRITERION;

    public RacingReferee(ArrayList<Car> cars, int criterion) {
        this.cars = cars;
        this.CRITERION = criterion;
    }

    public RaceResult race(){
        for (Car car : cars) {
            if (isHigherThanCriterion()) {
                car.go();
            }
        }

        return RaceResult.resultString(cars);
    }

    public String judge(){
        return RaceResult.winnerToString(cars);
    }

    private boolean isHigherThanCriterion(){
        return Util.getRandomNumber() >= this.CRITERION;
    }
}