package racingcar.domain;

import java.util.stream.Collectors;

/**
 * Race 에서 달리는 Cars 들을 관전하면서, 레이싱 상황을 컨트롤러에 주고, 컨트롤러는 뷰에 보내준다.
 */

public class Camera {

    private static final String COLON_DELIMITER = " : ";
    private static final String LINE = System.lineSeparator();

    public String displayRacingState(final Race race) {
        return race.getCarList()
                .stream()
                .map(car -> car.getName() + COLON_DELIMITER + generateHyphens(car.getForwardCount()))
                .collect(Collectors.joining(LINE));
    }

    private String generateHyphens(final int forwardCount) {
        if (forwardCount <= 0) return "";
        return "-".repeat(forwardCount);
    }
}