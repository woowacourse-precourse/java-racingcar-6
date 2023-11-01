package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;
import java.util.HashMap;

class CarTest {
    Car carName;
    final static String NAME_ERROR_MSG = "5글자가 넘는 이름은 입력하실 수 없습니다!";

    @Test
    void enterName_예외_테스트() {
        Map<String, Integer> names = new HashMap<>();
        names.put("Integer", 0);

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> carName = new Car(names));

        assertThat(e.getMessage()).isEqualTo(NAME_ERROR_MSG);
    }

}