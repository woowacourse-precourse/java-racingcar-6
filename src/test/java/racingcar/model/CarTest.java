package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
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
import racingcar.util.RandomUtil;

@DisplayName("자동차 모델에 대한 테스트")
class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun", "test", "abcde"})
    @DisplayName("자동차 생성")
    void initCar(String carName) {
        // give
        // when
        Car car = Car.make(carName);
        // then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @MethodSource("carNameProvider")
    @DisplayName("이름 길이는 5자 이하여야 함")
    void init_CarNameLengthThanLimit(String carName) {
        // given
        // when
        // then
        assertThatThrownBy(() -> Car.make(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "   "})
    @DisplayName("자동차의 이름은 빈 문자열이 될 수 없음")
    void init_CarNameIsEmpty() {
        // given
        String carName = "";
        // when
        // then
        assertThatThrownBy(() -> Car.make(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("무작위 값이 4보다 크거나 같다면 전진할 수 있음")
    void move_RandomValue_IncreaseMoveCnt(int value) {
        // given
        Car car = Car.make("beom");
        MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class);
        int minRandomValue = 0;
        int maxRandomValue = 9;
        //when
        when(Randoms.pickNumberInRange(minRandomValue, maxRandomValue)).thenReturn(value);
        CarStatus carStatus = car.moveOrStop(RandomUtil.generateRandomValue(minRandomValue, maxRandomValue));
        // then
        assertAll(
                () -> assertThat(carStatus.movedCnt()).isEqualTo(1),
                () -> assertThat(carStatus.name()).isEqualTo("beom")
        );
        mockRandoms.close();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("무작위 값이 4보다 작다면 전진할 수 없음")
    void move_RandomValueLessThanCriteria(int value) {
        // given
        Car car = Car.make("pobi");
        MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class);
        int minRandomValue = 0;
        int maxRandomValue = 9;

        //when
        when(Randoms.pickNumberInRange(minRandomValue, maxRandomValue)).thenReturn(value);
        CarStatus carStatus = car.moveOrStop(RandomUtil.generateRandomValue(minRandomValue, maxRandomValue));

        // then
        assertAll(
                () -> assertThat(carStatus.movedCnt()).isZero(),
                () -> assertThat(carStatus.name()).isEqualTo("pobi")
        );
        mockRandoms.close();
    }

    private static Stream<Arguments> carNameProvider() {
        return Stream.of(
                Arguments.of("pobiwoni"),
                Arguments.of("pobijun"),
                Arguments.of("pobiwonijun"),
                Arguments.of("testtest"),
                Arguments.of("123456789")
        );
    }
}