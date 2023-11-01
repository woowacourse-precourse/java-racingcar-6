package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.mockito.Mockito.*;

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

        String name = "test1";

        // Utils 클래스의 getRandom 메서드를 목(Mock) 객체로 대체
        Utils utils = mock(Utils.class);
        when(utils.getRandomNumber()).thenReturn(6); // 원하는 반환 값을 설정

        Car car = new Car(name);
        car.moveForward();

        // position 값이 1 증가 했는지 확인
        Assertions.assertEquals(1, car.getPosition());
    }
}
