package racingcar.vo;

import java.util.List;

public class RacingInfo {
    private final CarCollection carCollection;
    private final Integer repeatCount;

    public RacingInfo(CarCollection carCollection, Integer repeatCount) {
        this.carCollection = carCollection;
        this.repeatCount = repeatCount;
    }

    public CarCollection getCarCollection() {
        return this.carCollection;
    }

    public List<CarInfo> getCarList() {
        return this.carCollection.getCarList();
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }
}
