package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static racingcar.Car.createCarByName;

class CarTest {

    @Test
    void createCarByName_메서드에서_유효한_이름으로_Car_오브젝트_생성() {
        String validName = "abcd";
        Car car = createCarByName(validName);
        assertThat(car.getName()).isEqualTo(validName);
    }

    @Test
    void createCarByName_메서드에서_긴_이름에_대한_예외_처리() {
        String longName = "abcdef";
        assertThatThrownBy(() -> createCarByName(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하의 이름만 입력해주세요");
    }
}