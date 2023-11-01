package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 자동차별 각 레이스별 위치 리스트 가진 클래스
 */
public class RaceRecord {
    Car car;
    List<Integer> raceRecord;

    public RaceRecord() {
    }

    public RaceRecord(Car car, List<Integer> raceResult) {
        this.car = car;
        this.raceRecord = new ArrayList<>(raceResult);
    }

    public Car getCar() {
        return car;
    }

    public List<Integer> getRaceResult() {
        return Collections.unmodifiableList(raceRecord);
    }
}
