package racingcar.cars;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("자동차 이름은 쉼표(,)로 구분하여 리스트에 저장하는지 테스트")
    public void testCarNamesAreParsedAndStore() {
        Cars cars = new Cars("tiger,eagle,bear");

        List<String> expectedList = Arrays.asList("tiger", "eagle", "bear");

        Assertions.assertThat(cars.getCars()).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("입력값에 최대 길이(5)를 초과하는 자동차 이름이 포함되어 있을 때 에러가 발생 테스트 ")
    public void testInputCarNameExceedsMaxLength() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cars("lion,leopard,cow"));
    }
}
