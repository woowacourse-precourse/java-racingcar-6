package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static racingcar.constant.ErrorMessage.CAR_NAME_DUPLICATED;
import static racingcar.constant.ErrorMessage.NUMBER_OF_CAR_NAME_IS_ONE_OR_LESS;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STAY = 3;

    @Test
    @DisplayName("쉼표 기준으로 파싱하면 car1과 car2을 이름으로 가진 자동차가 각각 생성되므로 toString()을 호출했을 때 각각의 자동차에 대한 정보를 출력해야한다.")
    void 입력_받은_자동차_이름을_쉼표_기준으로_파싱하는_기능() {
        RacingCars racingCars = new RacingCars("car1,car2");
        assertAll(
                () -> assertThat(racingCars.toString()).contains("car1", "car2"),
                () -> assertThat(racingCars.toString()).doesNotContain("car1,car2")
        );
    }

    @Test
    void 자동차_생성() {
        RacingCars racingCars = new RacingCars("car1,car2");
        assertThat(racingCars).isNotNull();
    }

    @Test
    void 자동차의_이름은_중복되어선_안된다() {
        assertThatThrownBy(() -> new RacingCars("car1,car2,car1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_DUPLICATED);
    }

    @Test
    void 자동차의_이름은_2개_이상이어야_한다() {
        assertThatThrownBy(() -> new RacingCars("car1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_OF_CAR_NAME_IS_ONE_OR_LESS);
    }

    @Test
    void 랜덤값에_따라_자동차들의_경주를_진행할_수_있다() {
        RacingCars racingCars = new RacingCars("car1,car2,car3");
        assertRandomNumberInRangeTest(
                () -> {
                    racingCars.race();
                },MOVING_FORWARD,STAY,MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {

    }
}