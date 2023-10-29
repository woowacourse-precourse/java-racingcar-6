package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 이름을_받아_자동차_객체_생성() {
        Car car = new Car("chan");

        String name = car.getName();
        int positionLength = car.getPositionLength();

        assertThat(name).isEqualTo("chan");
        assertThat(positionLength).isEqualTo(0);
    }

    @Test
    void 자동차_위치_이동() {
        Car car = new Car("chan");
        car.moveForward();

        int positionLength = car.getPositionLength();
        assertThat(positionLength).isEqualTo(1);
    }

    @Test
    void 위치_길이_반환() {
        Car car = new Car("chan");
        int positionLength = car.getPositionLength();

        assertThat(positionLength).isEqualTo(0);
    }

    @Test
    void 이름과_위치_반환() {
        Car car = new Car("chan");
        String nameAndPosition = car.nameAndPosition();

        assertThat(nameAndPosition).isEqualTo("chan : ");
    }

    @Test
    void 포지션_길이가_일치하는지_반환_일치하는_경우() {
        Car car = new Car("chan");
        boolean isWinner = car.isWinner(0);

        assertThat(isWinner).isTrue();
    }

    @Test
    void 포지션_길이가_일치하는지_반환_불일치하는_경우() {
        Car car = new Car("chan");
        boolean isWinner = car.isWinner(1);

        assertThat(isWinner).isFalse();
    }
}