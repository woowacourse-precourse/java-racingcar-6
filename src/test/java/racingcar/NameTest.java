package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import racingcar.model.Name;

public class NameTest {

    @Test
    @DisplayName("자동차 이름이 올바르게 입력된 경우")
    void carNameTest() throws Exception{
        //given
        String value =  "pobi";

        //when
        Name name = new Name(value);

        //then
        assertThat(name.getName()).isEqualTo("pobi");
    }
    @Test
    @DisplayName("자동차 이름이 띄워쓰기와 함께 입력된 경우")
    void carNameTest2() throws Exception{
        //given
        String value =  "pobi ";

        //when
        Name name = new Name(value);

        //then
        assertThat(name.getName()).isEqualTo("pobi");
    }
}
