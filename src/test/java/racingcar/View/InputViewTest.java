package racingcar.View;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class InputViewTest {
    InputView inputView;
    String name;

    @BeforeEach
    public void init() {
        //given
        inputView = new InputView();
    }

    @Test
    @DisplayName("자동차의 이름은 , 으로 구별하여 입력한다.")
    public void Input1() {
        name = "pobi,woni,jun";

        //then
        assertThat(inputView.inputCarname(name)).isEqualTo(name);
        assertThat(inputView.SplitCarname(name)).contains("pobi", "woni", "jun");
        assertThat(inputView.getCars().get(0)).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차의 이름은 5자리로 입력하는 판별기능")
    public void Input2() {

        name = "pobi,woni,JUUUUN";
        assertThat(inputView.valideFivename(name)).isFalse();

    }
}
