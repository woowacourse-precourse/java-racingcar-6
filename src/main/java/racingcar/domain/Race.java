package racingcar.domain;

import racingcar.util.RandomNumberGenerator;
import racingcar.util.constant.ConstStandard;

import java.util.List;
import java.util.ArrayList;

public class Race {

    private final List<RacingCar> racingCars;

    public Race(List<String> carNames) {
        this.racingCars = new ArrayList<>();

        // 입력된 이름들로 RacingCar 갹체들을 만들어 주입합니다.
        for (String carName : carNames) {
            this.racingCars.add(new RacingCar(carName));
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public Long getMostFarthestDistance() {
        Long farthestDistance = 0L;
        for (RacingCar car : racingCars) {
            if (isFarthest(car.getDistance(), farthestDistance)) {
                farthestDistance = car.getDistance();
            }
        }
        return farthestDistance;
    }

    public void circuit() {
        for (RacingCar car : racingCars) {
            if (isRacingCarMove()) {
                car.move();
            }
        }
    }

    private boolean isRacingCarMove() {
        int movingValue = RandomNumberGenerator.generate();
        return movingValue >= ConstStandard.CRITERIA_MOVE;
    }
    private boolean isFarthest(long targetDistance, long elderFarthestDistance) {
        return targetDistance > elderFarthestDistance;
    }
}
