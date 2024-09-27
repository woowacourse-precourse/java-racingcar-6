package racingcar.domain;

import racingcar.domain.entity.CarEntity;

import java.util.List;

public class JudgeMoveCar {
    public static void moveCar(List<CarEntity> cars) {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        cars.stream()
                .filter(car -> numberGenerator.numberGenrate() >= 4)
                .forEachOrdered(MoveCarPosition::move);
    }
}
