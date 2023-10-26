package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarMovementTest {

    @Test
    @DisplayName("생성시 0으로 초기화 된다")
    void init0_whenConstructed() {
        // given, when
        CarMovement carMovement = new CarMovement();

        // then
        assertThat(carMovement.toString()).isEqualTo("");
    }

    @Test
    @DisplayName("goForward() 가 movement를 1 증가시킨다.")
    void goForwardIncreaseMovement1() {
        // given
        CarMovement carMovement = new CarMovement();

        // when
        carMovement.goForward();

        // then
        assertThat(carMovement.toString()).isEqualTo("-");
    }

    @Test
    @DisplayName("toString() 이 이동 횟수 만큼의 '-' 반환한다.")
    void toStringReturnValueOfDashes() {
        // given
        CarMovement carMovement = new CarMovement();
        carMovement.goForward();
        carMovement.goForward();

        // when
        String message = carMovement.toString();

        // then
        assertThat(message).isEqualTo("--");
    }

    @Test
    @DisplayName("equals() 가 같은 값을 가지는 CarMovement에 대해 true를 반환한다.")
    void equalsReturnTrue_whenSameValueInput() {
        // given
        CarMovement carMovement1 = new CarMovement();
        carMovement1.goForward();
        CarMovement carMovement2 = new CarMovement();
        carMovement2.goForward();

        // when
        boolean result = carMovement1.equals(carMovement2);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("equals() 가 다른 값을 가지는 CarMovement에 대해 true를 반환한다.")
    void equalsReturnFalse_whenDifferentValueInput() {
        // given
        CarMovement carMovement1 = new CarMovement();
        CarMovement carMovement2 = new CarMovement();
        carMovement2.goForward();

        // when
        boolean result = carMovement1.equals(carMovement2);

        // then
        assertThat(result).isFalse();
    }
}