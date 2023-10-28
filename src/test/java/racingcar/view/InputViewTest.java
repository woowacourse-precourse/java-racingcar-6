package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {

    InputView inputView = new InputView();
    @Test
    void 입력된_자동차_이름을_list로_변환(){
        //given
        String name = ("pobi,woni,jun");
        //when
        List<String> names = inputView.toStringList(name);
        //then
        assertThat(List.of("pobi", "woni", "jun")).isEqualTo(names);
    }

    @Test
    void 입력된_자동차_이름이_5자보다_많으면_예외() {
        //given
        List<String> names = List.of("pobi", "woni", "jun", "jieung");
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> inputView.validateName(names));
        //then
        assertThat(e.getMessage()).isEqualTo("자동차 이름은 5자 이내로 입력해주세요.");
    }
}
