package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
 * 해당 테스트는 privqte 메서드인 isMoveFoward()에 대한 테스트 입니다.
 * private메서드에 대한 테스트는 지양해야 하지만 테스트에 대해서 공부하고자
 * 간단한 메서드에 대한 테스트를 작성하기 위해 잠시 public으로 변경한 뒤에 테스트를 진행해봤습니다.
 */

public class RacingCarTest{

    @DisplayName("5가 입력되었을 때 제대로 전진")
    @Test
    void 전진_확인() {
        RacingCar racingCar = new RacingCar("temp",0);
        assertThat(racingCar.isMoveFoward(5)).isTrue();
    }

    @DisplayName("3이 입력되었을 때 제대로 멈춤")
    @Test
    void 멈춤_확인() {
        RacingCar racingCar = new RacingCar("temp",0);
        assertThat(racingCar.isMoveFoward(3)).isFalse();
    }
}