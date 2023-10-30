package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.List;
import org.junit.jupiter.api.Test;

class InputRacingCarTest {



    @Test
    void split_이름_구분() {
        List<String> result = InputRacingCar.nameSeparator("pobi,woni,jun");
        assertThat(result).contains("pobi", "jun","woni");
        assertThat(result).containsExactly("pobi","woni","jun");
    }

    @Test
    void split_이름_구분자가_없을_경우_그대로_반환() {
        List<String> result = InputRacingCar.nameSeparator("pobi");
        assertThat(result).contains("pobi");
    }

   
}