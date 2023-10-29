package service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarServiceTest {

    private RacingCarService racingCarService = new RacingCarService();

    @Test
    @DisplayName(value = "자동차 생성 시, 입력된 차량 이름의 갯수와 생성된 차량의 수가 동일한지 확인")
    void generateRacingCarTest() {
        assertThat(racingCarService.generateRacingCar(new HashSet<>(Arrays.asList("Ford", "GM", "TESLA"))))
                .isEqualTo(3);

        assertThat(racingCarService.generateRacingCar(new HashSet<>(Arrays.asList("Ford", "GM", "TESLA", "LUCID"))))
                .isEqualTo(4);
    }

}