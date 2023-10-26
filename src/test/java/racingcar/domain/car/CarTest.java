package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

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
        assertThat(car.toString()).isEqualTo("wan : ");
    }

    @ParameterizedTest
    @CsvSource({
        "1, ''", "2, ''", "3, ''",
        "4, -", "5, -", "6, -", "7, -", "8, -", "9, -",
    })
    @DisplayName("move() 가 4 이상의 임의 값이 생성되었을 때만 이동 횟수를 1 증가시킨다.")
    void moveIncrease1_whenValueIsOver4(final int value, final String expectedDashes) {
        // given
        Car car = new Car("wan");
        MockedStatic<Randoms> randoms = mockStatic(Randoms.class);
        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(value);

        // when,
        car.move();

        // then
        assertThat(car.toString()).isEqualTo("wan : " + expectedDashes);

        randoms.close();
    }

    @Test
    @DisplayName("toString() 이 이름과 이동 횟수를 '-'로 변환한 문자열을 반환한다.")
    void toStringReturnNameAndConvertedDashes() {
        // given
        String name = "wan";
        Car car = new Car(name);

        MockedStatic<Randoms> randoms = mockStatic(Randoms.class);
        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(5);

        int movement = 3;
        String expectedDashes = "";
        for (int i = 0; i < movement; i++) {
            car.move();
            expectedDashes += "-";
        }

        // when
        String message = car.toString();

        // then
        assertThat(message).isEqualTo(name + " : " + expectedDashes);

        randoms.close();
    }
}