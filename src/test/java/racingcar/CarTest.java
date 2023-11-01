package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.List;

class CarTest {
    @Test
    @DisplayName("자동차 이름 입력 길이 5초과 테스트")
    public void carNameLengthOver5Test() {
        //given
        String carName = "aaaaaa";
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(carName));
    }

    @Test
    @DisplayName("자동차 이름 입력 NULL 테스트")
    public void carNameIsNullTest() {
        //given
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }

    @Test
    @DisplayName("자동차 이름 입력 중복 테스트")
    public void duplicatedCarNameTest() {
        //given
        List<String> carNames = Arrays.asList("user", "user");
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Cars(carNames));
    }
}
