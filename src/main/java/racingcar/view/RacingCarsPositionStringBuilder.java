package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.CarPosition;

public class RacingCarsPositionStringBuilder {

    private static final String POSITION_BLOCK = "-";

    public static String buildCurrentRacingCarsPosition(List<CarPosition> carPositions) {
        return carPositions.stream()
            .map(carPosition -> carPosition.name() + " : " + getPositionBar(carPosition.position()))
            .collect(Collectors.joining("\n"));
    }

    private static String getPositionBar(int carPosition) {
        return POSITION_BLOCK.repeat(carPosition);
    }
}
