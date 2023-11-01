package racingcar.race;

import racingcar.vo.CarCollection;
import racingcar.vo.CarInfo;

import java.util.List;
import java.util.Map;

public class RacingResultHandler implements Handler<CarCollection, CarCollection> {

    public CarCollection execute(final CarCollection carCollection) {
        return extractWinCars(carCollection);
    }

    private static CarCollection extractWinCars(CarCollection carCollection) {
        final Map<Integer, List<CarInfo>> group = carCollection.groupByMoveCnt();
        return getValueFromMaxValue(group);
    }

    private static CarCollection getValueFromMaxValue(Map<Integer, List<CarInfo>> collect) {
        final Integer maxMoveCnt = collect.keySet().stream().max(Integer::compareTo).orElse(0);
        return new CarCollection(collect.get(maxMoveCnt));
    }
}
