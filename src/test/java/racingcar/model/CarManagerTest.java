package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[Car Manager]")
class CarManagerTest {

    @Test
    @DisplayName("생성자 테스트")
    public void constructorTest() {
        assertThat(new CarManager(List.of(
                new RacingCar("b"),
                new RacingCar("cd")))
        ).isEqualTo(new CarManager(List.of(
                new RacingCar("b"),
                new RacingCar("cd")))
        );

    }

    @Test
    @DisplayName("자동차 이름 정상적으로 입력")
    public void validCarNames() {
        final String carNames = "abc,def,자동차1,자동차2,자동차3";
        Assertions.assertDoesNotThrow(
                () -> new CarManager(carNames)
        );
        org.assertj.core.api.Assertions.assertThat(
                new CarManager("abc,def,자동차1,자동차2,자동차3").getCars().size()).isEqualTo(5);
    }


}