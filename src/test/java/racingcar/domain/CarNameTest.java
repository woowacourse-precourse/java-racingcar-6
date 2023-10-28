package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    @DisplayName("이름에 공백이 포함되면 예외가 발생한다.")
    void createCarNameByEmptySpace(){
        assertThatThrownBy(() -> new CarName("msung99 "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 1자 이하라면 예외가 발생한다.")
    void createByUnderLength(){
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외가 발생한다.")
    void createByOverLength(){
        assertThatThrownBy(() -> new CarName("abcdefg"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
