package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AcceleratorTest {

    @Test
    void 숫자가_4이상일_때_true를_반환하는지_테스트() {
        //given
        Accelerator accelerator = new Accelerator();
        //when
        boolean canGo = accelerator.canGo(4);
        //then
        Assertions.assertThat(canGo).isTrue();
    }

    @Test
    void 숫자가_4미만일_때_false를_반환하는지_테스트() {
        //given
        Accelerator accelerator = new Accelerator();
        //when
        boolean canGo = accelerator.canGo(3);
        //then
        Assertions.assertThat(canGo).isFalse();
    }
}
