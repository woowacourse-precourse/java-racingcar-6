package model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void 이름_5자_초과에_대한_예외_처리() {
        String name = "leenayeon";
        assertThatThrownBy(() -> {
            new Name(name);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

}