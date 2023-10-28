package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

public class CarNamesTest {
    @Test
    @DisplayName("이름에 공백이 포함되면 예외가 발생한다.")
    void createCarNamesByEmptySpace(){
        assertThatThrownBy(() -> CarNames.from("a,b,c,d"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
