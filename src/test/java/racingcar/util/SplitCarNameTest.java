package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SplitCarNameTest {

    @DisplayName("자동차는 쉼표(,)를 기준으로 구분하여 생성된다.")
    @Test
    void splitCarName() throws Exception{
        //given
        String playerInput = "pobi,woni,jun,cobi";
        SplitCarName splitCarName = new SplitCarName();
        String[] strings = splitCarName.splitCarNames(playerInput);

        //when //then
        assertThat(strings).hasSize(4)
                .containsExactly(new String[]{"pobi","woni","jun","cobi"});
    }
}