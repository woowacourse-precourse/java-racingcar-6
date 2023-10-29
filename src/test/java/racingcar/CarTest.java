package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racingcar.model.Car;

@DisplayName("자동차 모델에 대한 테스트")
class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"beom", "seok", "kevin", "test"})
    @DisplayName("자동차 생성 테스트")
    void initCar(String carName) {
        // give
        // when
        Car car = new Car(carName);

        // then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @MethodSource("carNameProvider")
    @DisplayName("자동차의 이름 길이에 따른 예외처리 테스트")
    void init_CarNameLengthThanLimit_ThrownException(String carName) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "   ", "    ", "     "})
    @DisplayName("자동차의 이름으로 빈 문자열이 들어오면 예외를 호출한다.")
    void init_CarNameIsEmpty_ThrownException() {
        // given
        String carName = "";

        // when
        // then
        assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("무작위 값이 정해진 값보다 크거나 같은 경우 자신이 움직인 횟수의 카운트를 증가시킨다.")
    void move_RandomValueMoreThanCriteria_IncreaseMoveCount(int value) {
        // given
        Car car = new Car("beom");
        MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class);

        //when
        when(Randoms.pickNumberInRange(0, 9)).thenReturn(value);
        car.move();

        // then
        assertThat(car.getMovedCount()).isEqualTo(1);
        mockRandoms.close();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("무작위값이 정해진 값보다 작은 경우 움직이지 않는다.")
    void move_RandomValueLessThanCriteria(int value) {
        // given
        Car car = new Car("beom");
        MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class);

        //when
        when(Randoms.pickNumberInRange(0, 9)).thenReturn(value);
        car.move();

        // then
        assertThat(car.getMovedCount()).isZero();
        mockRandoms.close();
    }

    private static Stream<Arguments> carNameProvider() {
        return Stream.of(
                Arguments.of("beomsic"),
                Arguments.of("beomseok"),
                Arguments.of("kobeomseok"),
                Arguments.of("testname"),
                Arguments.of("123456"),
                Arguments.of("12345678"),
                Arguments.of("123456789")
        );
    }
}
