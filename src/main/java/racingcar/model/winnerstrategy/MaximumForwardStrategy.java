package racingcar.model.winnerstrategy;

import java.util.List;
import racingcar.model.Cars;

public class MaximumForwardStrategy implements WinnerStrategy {
    @Override
    public List<String> findWinnerCarNames(Cars cars) {
        int maxForwardCount = cars.calculateMaxForwardCount();
        return cars.findAllNameByForwardCount(maxForwardCount);
    }
}
