package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNamesTest {
    @Test
    @DisplayName("이름 리스트에 중복이 포함되면 예외가 발생한다.")
    void createByDuplicateElements(){
        assertThatThrownBy(() -> CarNames.from("a,a,c,d"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 이름이 2개 이하라면 예외가 발생한다.")
    void createByUnderSize(){
        assertThatThrownBy(() -> CarNames.from("msung99"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
