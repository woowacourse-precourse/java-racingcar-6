package racingcar.domain;

import java.util.stream.Collectors;

/**
 * Race 에서 달리는 Cars 들을 관전하면서, 레이싱 상황을 컨트롤러에 주고, 컨트롤러는 뷰에 보내준다.
 */

public class Camera {

    private static final String COLON_DELIMITER = " : ";
    private static final String LINE = "\n";

    public String captureRaceState(final Race race) {
        return race.getCarList()
                .stream()
                .map(car -> car.getName() + COLON_DELIMITER + generatePositionDashString(car.getForwardCount()))
                .collect(Collectors.joining(LINE));
    }

    private String generatePositionDashString(final int position) {
        if (position <= 0) return "";
        return "-".repeat(position);
    }
}