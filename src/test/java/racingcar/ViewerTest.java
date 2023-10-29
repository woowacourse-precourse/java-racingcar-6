package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ViewerTest {
    private Viewer viewer = new Viewer();

    @Nested
    class 자동차_이름_입력 {
        @Test
        void 성공_입력받은_자동차의_이름을_쉼표로_구분() {
            String input = "pobi,woni";
            assertThat(viewer.convertToList(input)).containsExactly("pobi", "woni");
        }


    }
}
