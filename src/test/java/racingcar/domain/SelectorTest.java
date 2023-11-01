package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SelectorTest {
    private Selector selector;

    @BeforeEach
    void setUp() {
        selector = new Selector();
    }

    @Test
    void whetherToGo_메서드_사용시_전진_또는_정지_반환() {
        String result = selector.whetherToGo();

        assertThat(result).isBetween("전진", "정지");
    }

}