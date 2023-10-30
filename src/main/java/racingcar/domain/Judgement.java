package racingcar.domain;

import java.util.stream.Collectors;

import static racingcar.constant.Constant.COMMA_DELIMITER;
import static racingcar.constant.Constant.SPACE;

/**
 * 컨트롤러가 Judgement 에게 같은 Race 를 하는 Cars 들을 보내주면
 * Judgement 는 누가 가장 멀리 갔는지 (최종 우승자)를 판단한다.
 */

public class Judgement {

    public String determineWinners(final Cars cars) {
        int maxForwardCount = calculateMaxPosition(cars);

        return cars.cars()
                .stream()
                .filter(car -> car.getPosition() == maxForwardCount)
                .map(Car::getName)
                .collect(Collectors.joining(COMMA_DELIMITER + SPACE));
    }

    private int calculateMaxPosition(final Cars cars) {
        return cars.cars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
