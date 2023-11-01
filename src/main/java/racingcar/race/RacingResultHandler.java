package racingcar.race;

import racingcar.vo.CarCollection;
import racingcar.vo.CarInfo;

import java.util.List;
import java.util.Map;

class RacingResultHandler implements Handler<CarCollection> {

    private static final String RACING_RESULT_MESSAGE = "최종 우승자 : %s";

    RacingResultHandler() {
    }

    public void execute(final CarCollection carCollection) {
        final CarCollection winCarCollection = extractWinNames(carCollection);
        System.out.print(String.format(RACING_RESULT_MESSAGE, winCarCollection.getCarName()));
    }

    private static CarCollection extractWinNames(CarCollection carCollection) {
        final Map<Integer, List<CarInfo>> group = carCollection.groupByMoveCnt();
        return getValueFromMaxValue(group);
    }

    private static CarCollection getValueFromMaxValue(Map<Integer, List<CarInfo>> collect) {
        return new CarCollection(collect.values().iterator().next());
    }
}
