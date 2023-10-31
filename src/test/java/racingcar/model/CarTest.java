package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    public void 자동차_생성() {
        // given
        String name = "test1";
        // when
        Car car = new Car(name);
        // then
        assertThat(car).isNotNull();
    }

    @ParameterizedTest // 여러 입력 값을 받아서 여러 번 실행
    @ValueSource(strings = {"" , "123456", ""})
    public void 자동차_생성_실패(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전진_정지() {

    }
}
