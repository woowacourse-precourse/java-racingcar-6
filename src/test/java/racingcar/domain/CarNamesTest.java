package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

public class CarNamesTest {
    @Test
    @DisplayName("이름 리스트에 중복이 포함되면 예외가 발생한다.")
    void createCarNamesByDuplicateElements(){
        assertThatThrownBy(() -> CarNames.from("a,a,c,d"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
