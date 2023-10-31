package racingcar.service;

import racingcar.domain.RaceResult;
import racingcar.domain.Car;

import java.util.ArrayList;

public class RacingReferee {
    // 레이싱 게임을 실행에 대한 책임을 다하는 심판
    private ArrayList<Car> cars;
    private Integer racingRound;

    public RacingReferee(ArrayList<Car> cars, Integer racingRound) {
        this.cars = cars;
        this.racingRound = racingRound;
    }

    public RaceResult race(){
        return null;
    }
}