package racingcar.util.style;

import java.util.stream.IntStream;

public class DashDistanceStyle implements DistanceStyle {
    private static final String STRING_ONE_DISTANCE = "-";

    public DashDistanceStyle() {
        // Empty
    }

    @Override
    public String getDistanceString(int distance) {
        final StringBuilder builder = new StringBuilder(distance);

        IntStream.rangeClosed(1, distance)
                .forEach(value -> builder.append(STRING_ONE_DISTANCE));

        return builder.toString();
    }
}
