package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNamesTest {
    @Test
    void createByDuplicateElements(){
        assertThatThrownBy(() -> CarNames.from("a,a,c,d"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createByUnderSize(){
        assertThatThrownBy(() -> CarNames.from("msung99"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
