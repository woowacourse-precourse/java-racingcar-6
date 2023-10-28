package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("입력한 값을 split으로 배열로 만들기")
    void 입력_테스트() {
        //직접 입력하는 것으로 Console.readline() 대체
        String input = "pobi,woni,jun";
        String[] names = input.split(",");

        assertThat(names).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }
}