package racingcar.service;

import racingcar.domain.Car;

public class RecordService {

    public String madeCarResult(Car car) {
        StringBuilder madeResult = new StringBuilder();
        madeResult.append(car.getName()).append(" : ");
        madeResult.append("-".repeat(Math.max(0, car.getMoveCount())));
        return madeResult.toString();
    }
}
