package racingcar.service;

import racingcar.domain.Car;

public class RecordService {

    private static final String TRACE = "-";
    private static final String COLONE = " : ";

    public String madeCarResult(Car car) {
        StringBuilder madeResult = new StringBuilder();
        madeResult.append(car.getName()).append(COLONE);
        madeResult.append(TRACE.repeat(car.getMoveCount()));
        return madeResult.toString();
    }
}
