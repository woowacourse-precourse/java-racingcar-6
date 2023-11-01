package racingcar.service;

import static racingcar.constant.Sign.COLONE;
import static racingcar.constant.Sign.TRACE;

import racingcar.domain.Car;

public class RecordService {


    public String madeCarResult(Car car) {
        StringBuilder madeResult = new StringBuilder();
        madeResult.append(car.getName()).append(COLONE.getSign());
        madeResult.append(TRACE.getSign().repeat(car.getMoveCount()));
        return madeResult.toString();
    }
}
