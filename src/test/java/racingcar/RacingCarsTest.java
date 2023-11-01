package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @Test
    @DisplayName("쉼표 기준으로 파싱하면 car1과 car2을 이름으로 가진 자동차가 각각 생성되므로 toString()을 호출했을 때 각각의 자동차에 대한 정보를 출력해야한다.")
    void 입력_받은_자동차_이름을_쉼표_기준으로_파싱하는_기능() {
        RacingCars racingCars = new RacingCars("car1,car2");
        assertAll(
                () -> assertThat(racingCars.toString()).contains("car1", "car2"),
                () -> assertThat(racingCars.toString()).doesNotContain("car1,car2")
        );
    }

}