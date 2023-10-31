package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ErrorMessage.CAR_DUPLICATE_NAME_EXCEPTION_MESSAGE;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private PowerGenerator powerGenerator;

    @BeforeEach
    void setUp() {
        powerGenerator = new FixPowerGenerator();
    }

    @DisplayName("자동차 이름 중복일 때 예외 발생")
    @Test
    void 자동차_이름_중복_예외_발생() {
        assertThatThrownBy(() -> new Cars(List.of("aaa", "bbb", "aaa")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_DUPLICATE_NAME_EXCEPTION_MESSAGE);
    }

    @DisplayName("경주하는 모든 자동차의 전진을 확인한다.")
    @Test
    void 자동차들_전진_확인() {
        Cars cars = new Cars(List.of("aaa", "bbb", "ccc"));

        assertThatCode(() -> cars.move(powerGenerator))
                .doesNotThrowAnyException();
    }

    @DisplayName("경주하는 모든 자동차의 전진 문자열 출력을 확인한다.")
    @Test
    void 자동차들_전진_문자열_출력_확인() {
        Cars cars = new Cars(List.of("aaa", "bbb", "ccc"));
        String expected = "aaa : -\nbbb : -\nccc : -";

        cars.move(powerGenerator);

        assertThat(cars.statusMessage()).isEqualTo(expected);
    }

    @DisplayName("최종 우승한 자동차를 반환한다.")
    @Test
    void 최종_우승_자동차_반환() {
        Cars cars = new Cars(List.of("aaa", "bbb", "ccc"));

        cars.move(powerGenerator);

        assertThat(cars.winnerCars()).isEqualTo("aaa, bbb, ccc");
    }
}
