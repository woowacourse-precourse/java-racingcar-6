package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

public class RacingCarTest {
    private final String racingCarName = "pobi";

    @Test
    void RacingCar_객체_만들기() {
        RacingCar racingCar = new RacingCar(racingCarName);
        Assertions.assertThat(racingCar.getRacingCarName()).isEqualTo(racingCarName);
    }

    @Test
    void RacingCar_RandomNumber가_4이상이_나올때_전진_테스트() {
        int randomNumber = 5;
        RacingCar racingCar = new RacingCar(racingCarName);
        racingCar.move(randomNumber);
        Assertions.assertThat(racingCar.getMoveCount()).isEqualTo(1);
    }

    @Test
    void RacingCar_RandomNumber가_4보다_작을때_멈춤_테스트() {
        int randomNumber = 3;
        RacingCar racingCar = new RacingCar(racingCarName);
        racingCar.move(randomNumber);
        Assertions.assertThat(racingCar.getMoveCount()).isEqualTo(0);
    }
}
