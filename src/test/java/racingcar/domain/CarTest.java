package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("생성 시 이름 길이 유효성 평가: 실패")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "abcdef"})
    public void 예외테스트_이름_길이_실패(final String name) throws Exception {

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성 시 이름 길이 유효성 평가: 성공")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    public void 예외테스트_이름_길이_성공(final String name) throws Exception {
        assertThatNoException()
                .isThrownBy(() -> new Car(name));
    }

    @DisplayName("이동 시 조건 숫자 유효 평가: 이동 실패")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 예외테스트_자동차_이동_실패(int number) throws  Exception {
        //given
        String name = "car";
        Car car = new Car(name);
        int distanceBeforeMove = car.getDistance();
        //when
        car.move(number);
        int distanceAfterMove = car.getDistance();
        //then
        assertThat(distanceBeforeMove).isEqualTo(distanceAfterMove);
    }

    @DisplayName("이동 시 조건 숫자 유효 평가: 이동 성공")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 예외테스트_자동차_이동_성공(int number) throws  Exception {
        //given
        String name = "car";
        Car car = new Car(name);
        int distanceBeforeMove = car.getDistance();
        //when
        car.move(number);
        int distanceAfterMove = car.getDistance();
        int difference = 1;
        //then
        assertThat(distanceBeforeMove).isNotEqualTo(distanceAfterMove);
        assertThat(distanceBeforeMove + difference).isEqualTo(distanceAfterMove);
    }
}