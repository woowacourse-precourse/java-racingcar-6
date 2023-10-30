package racingcar.domain;

import java.util.stream.Collectors;

import static racingcar.constant.Constant.LINE;

/**
 * 경기 상황을 생중계 해주는 카메라 클래스
 * 컨트롤러를 통해 Camera 에게 Race 를 하고 있는 Cars 를 넘겨주면
 * Cars 들을 관전하면서, 레이싱 상황을 컨트롤러에 주고, 컨트롤러는 뷰에 보내준다.
 */

public class Camera {

    private static final String COLON_DELIMITER = " : ";

    public String captureRaceState(final Cars cars) {
        return cars.cars()
                .stream()
                .map(car -> car.getName() + COLON_DELIMITER + generatePositionDashString(car.getPosition()))
                .collect(Collectors.joining(LINE));
    }

    private String generatePositionDashString(final int position) {
        if (position <= 0) return "";
        return "-".repeat(position);
    }
}
