package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Car;
import domain.CarEngine;
import org.junit.jupiter.api.Test;
import racingcar.support.StubCarEngine;

public class CarTest {

    @Test
    void 이름이_5글자_초과면_예외를_던진다() {
        // given
        final String 여섯글자_이름 = "sixsix";
        final CarEngine 엔진 = new StubCarEngine();

        // when & then
        assertThatThrownBy(() -> new Car(여섯글자_이름, 엔진))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_2글자_미만이면_예외를_던진다() {
        // given
        final String 한글자_이름 = "1";
        final CarEngine 엔진 = new StubCarEngine();

        // when & then
        assertThatThrownBy(() -> new Car(한글자_이름, 엔진))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
