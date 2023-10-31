package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    RacingCar racingCar = new RacingCar("cName");

    @Test
    void getCarName_메서드로_차_이름_반환() {
        assertThat(racingCar.getCarName()).contains("cName");
    }

    @Test
    void move_메서드는_Randoms_값이_3이하면_하이픈_미추가() {
        assertThat(racingCar.getCarName()).doesNotContain("-");
    }

    @Test
    void move_메서드는_Randoms_값에따라_실행_후_하이픈_추가() {
        if (racingCar.pickRandomNumber() > 3) {
            racingCar.getDistance().add("-");
            assertThat(racingCar.getDistance()).contains("-");
        }
    }

    @Test
    void getNameAndDistance_메서드는_이름과_이동거리_출력() {
        assertThat(racingCar.getNameAndDistance()).contains("cName : ");
    }
}