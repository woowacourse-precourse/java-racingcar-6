package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    InputView inputView;

    @BeforeEach
    void beforeEach() {
        this.inputView = new InputView();
    }

    @Test
    @DisplayName("입력한 값을 split으로 배열로 만들기")
    void 입력_테스트() {
        //직접 입력하는 것으로 Console.readline() 대체
        inputView.setInputNames("pobi,woni,jun");

        assertThat(inputView.getInputNames()).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }
    
    @Test
    @DisplayName("이름에 공백이 존재하는 경우 예외 처리")
    void 예외_테스트1() {
        assertThatThrownBy(() -> inputView.setInputNames("pobi,woni, jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 제거해주세요.");

        assertThatThrownBy(() -> inputView.setInputNames("po bi,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 제거해주세요.");

        assertThatThrownBy(() -> inputView.setInputNames("pobi, ,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 제거해주세요.");

        assertThatThrownBy(() -> inputView.setInputNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 제거해주세요.");

        assertThatThrownBy(() -> inputView.setInputNames("pobi,,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 제거해주세요.");
    }

    @Test
    @DisplayName("이름의 길이가 5글자를 넘어서는 경우")
    void 예외_테스트2() {
        assertThatThrownBy(() -> inputView.setInputNames("qwerasdf"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1~5글자로 작성해주세요.");

    }
}