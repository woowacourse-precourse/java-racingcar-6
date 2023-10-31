package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class ResultView {
    private static final String POSITION_INDICATOR = "-";

    public void printRoundResult(final List<Car> cars) {
        cars.forEach(this::printCarPosition);
        System.out.println();
    }

    private void printCarPosition(final Car car) {
        System.out.println(car.getName() + " : " + getPositionLine(car.getPosition()));
    }

    private String getPositionLine(final int position) {
        return POSITION_INDICATOR.repeat(position);
    }
}
