package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    public void 이름_길이_5자리_이하만_가능(){
        List<String> input1 = Arrays.asList("JiHun","Sonata");

        assertThatThrownBy(() -> Validation.nameLimitLength(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자리 이하만 가능");
    }
}