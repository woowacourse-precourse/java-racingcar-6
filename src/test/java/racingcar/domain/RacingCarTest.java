package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    public static String name = "극동아시아";

    @Test
    void createRacingCar_이름을_입력받아_레이싱카_객체_생성() {
        // GIVEN

        // WHEN
        RacingCar racingCar = RacingCar.createRacingCar(name);

        // THEN
        assertThat(racingCar.getName()).isEqualTo(name);
    }


    @Test
    void putForward_레이싱카_위치를_한_칸_앞으로_이동() {
        // GIVEN
        RacingCar racingCar = RacingCar.createRacingCar(name);

        // WHEN
        racingCar.putForward();

        // THEN
        assertThat(racingCar.getLocation()).isEqualTo(NumberConstant.INITIAL_LOCATION + 1);
    }
}