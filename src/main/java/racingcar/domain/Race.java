package racingcar.domain;

import static racingcar.utils.RandomGenerator.generateRandomNumber;
import static racingcar.view.ResultView.printRaceResult;
import static racingcar.view.ResultView.printWinners;

import java.util.List;

/**
 * <p>자동차 경주 게임을 위한 {@code Race} 클래스입니다.</p>
 */
public class Race {

    private final List<Car> cars;
    private final int attemptCount;

    /**
     * <p>{@code Race} 객체를 생성합니다.</p>
     *
     * @param cars         참가하는 자동차들의 목록
     * @param attemptCount 경주 시도 횟수
     */
    public Race(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    /**
     * <p>자동차 경주를 시작합니다.</p>
     * <p>지정된 시도 횟수 동안 각 자동차가 움직임을 시도하고, 경주 결과를 출력합니다.</p>
     */
    public void startRace() {
        for (int i = 0; i < attemptCount; i++) {
            for (Car car : cars) {
                car.tryMove(generateRandomNumber());
            }
            printRaceResult(cars);
        }
        printWinners(findWinners());
    }

    /**
     * <p>가장 멀리 이동한 자동차(들)을 찾아 반환합니다.</p>
     *
     * @return 가장 멀리 이동한 자동차(들)의 목록
     */
    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    /**
     * <p>참가하는 자동차들 중에서 가장 멀리 이동한 거리를 찾아 반환합니다.</p>
     *
     * @return 가장 멀리 이동한 거리
     */
    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
