package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.Constant.ZERO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("전진 테스트")
    @Test
    void canMoveTest() {
        //given
        DriveStrategy driveStrategy = new RandomDriveStrategy();
        Car pobi = new Car(driveStrategy, "pobi", ZERO.number);

        //when
        pobi.move();

        //then
        assertThat(pobi.getPosition()).isNotNull(); // 랜덤 테스트 어떻게 짤까?
    }
}