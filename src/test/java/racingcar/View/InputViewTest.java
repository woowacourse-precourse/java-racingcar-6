package racingcar.View;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class InputViewTest {

    @Test
    @DisplayName("자동차의 이름은 , 으로 구별하여 입력한다.")
    public void Input1() {
        //given
        InputView inputView = new InputView();

        //when
        String name = "pobi,woni,jun";


        //then
        assertThat(inputView.inputCarname(name)).isEqualTo(name);
        assertThat(inputView.SplitCarname(name)).contains("pobi","woni","jun");
        assertThat(inputView.getCars().get(0)).isEqualTo("pobi");


    }
}
