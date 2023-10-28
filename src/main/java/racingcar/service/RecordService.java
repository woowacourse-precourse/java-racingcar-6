package racingcar.service;

import racingcar.domain.Car;

public class RecordService {

    public String madeCarResult(Car car) {
        StringBuilder madeResult = new StringBuilder();
        madeResult.append(car.getName()).append(" : ");
        for(int i=0; i<car.getMoveCount(); i++){
            madeResult.append("-");
        }
        return madeResult.toString();
    }
}
