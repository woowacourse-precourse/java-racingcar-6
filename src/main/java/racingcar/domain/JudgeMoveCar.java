package racingcar.domain;

import racingcar.domain.entity.CarEntity;

import java.util.List;

public class JudgeMoveCar {
    public static void MoveCar(List<CarEntity> cars) {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        cars.stream()
                .forEach(car -> {
                    if (numberGenerator.NumberGenrate() >= 4) {
                        MoveCarPosition.move(car);
                    }
                });
    }
}
