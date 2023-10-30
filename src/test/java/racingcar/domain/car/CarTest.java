package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

class CarTest {

    @Test
    @DisplayName("문자열(자동차 이름)으로 생성할 수 있다.")
    void canConstructByString() {
        // given
        String name = "wan";

        // when
        Car car = new Car(name);

        // then
        assertThat(car.name()).isEqualTo("wan");
        assertThat(car.movement().movement()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 0", "2, 0", "3, 0",
        "4, 1", "5, 1", "6, 1", "7, 1", "8, 1", "9, 1",
    })
    @DisplayName("move() 가 4 이상의 임의 값이 생성되었을 때만 이동 횟수를 1 증가시킨다.")
    void moveIncrease1_whenValueIsOver4(final int value, final int expectedValue) {
        // given
        Car car = new Car("wan");
        MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class);
        mockedRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(value);

        // when,
        car.move();

        // then
        assertThat(car.name()).isEqualTo("wan");
        assertThat(car.movement().movement()).isEqualTo(expectedValue);

        mockedRandoms.close();
    }

    @Test
    @DisplayName("isSameDistance() 가 같은 위치에 있는 Car가 입력으로 들어오면 true를 반환한다.")
    void isSameDistanceReturnTrue_whenSameDistanceCarInput() {
        // given
        String name1 = "car1";
        Car car1 = new Car(name1);

        String name2 = "car2";
        Car car2 = new Car(name2);

        // when
        boolean result = car1.isSameDistance(car2);

        // then
        assertThat(result).isTrue();
    }
}