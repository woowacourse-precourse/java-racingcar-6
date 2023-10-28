package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarTest {
    @Test
    void 이름을_입력받으면_자동차가_생성된다(){
        // Arrange
        String carName = "phobi";
        // Action, Assert
        RacingCar racingCar = new RacingCar(carName);
        assertThat(racingCar.name).isEqualTo(carName);
    }

    @Test
    void 이름자리수가_5자_초과이면_예외처리한다(){
        // Arrange
        String carName = "javaji";
        // Action, Assert
        assertThatThrownBy(() -> new RacingCar(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤수가_4이상인경우_전진(){
        // Arrange
        String carName = "phobi";
        RacingCar racingCar = new RacingCar(carName);
        // Action
        racingCar.move(4);
        // Assert
        assertThat(racingCar.block.stream().count()).isEqualTo(1);
    }
}
