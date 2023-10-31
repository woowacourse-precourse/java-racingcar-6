package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import racingcar.model.Name;

public class NameTest {

    @Test
    @DisplayName("자동차 이름이 띄워쓰기와 함께 입력된 경우 공백이 제거된 자동차 이름을 반환한다.")
    void carNameTest2() throws Exception{
        //given
        String value =  "pobi ";

        //when
        Name name = new Name(value);

        //then
        assertThat(name.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차 이름이 띄워쓰기 여러개와 함께 입력된 경우 공백이 제거된 자동차 이름을 반환한다.")
    void carNameTest3() throws Exception{
        //given
        String value =  "  a ";

        //when
        Name name = new Name(value);

        //then
        assertThat(name.getName()).isEqualTo("a");
    }

    @Test
    @DisplayName("자동차 이름이 6글자 이상인 경우 오류를 반환한다.")
    void carNameTest4() throws Exception{
        //given
        String value =  "abcdef";

        //when, then
        assertThatThrownBy(() -> {
            Name name = new Name(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 이하인 경우 자동차 이름을 반환한다.")
    void carNameTest5() throws Exception{
        //given
        String value =  "abcdef";

        //when, then
        assertThatThrownBy(() -> {
            Name name = new Name(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
