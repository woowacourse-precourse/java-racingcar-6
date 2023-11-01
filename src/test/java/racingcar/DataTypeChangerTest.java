package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.DataTypeChanger;

public class DataTypeChangerTest {

    @Test
    void 스트링을_쉼표_기준으로_리스트를_만든다() {
        List<String> names = DataTypeChanger.stringToList("123,234,345");
        assertThat(names.equals(DataTypeChanger.stringToList("123,234,345"))).isTrue();
    }
    @Test
    void 스트링_리스트를_Car_리스트로_만든다() {
        List<String> names = DataTypeChanger.stringToList("123,234,345");

        DataTypeChanger.stringToCar(names).forEach(value -> assertThat(value).isInstanceOf(Car.class));
    }
}
