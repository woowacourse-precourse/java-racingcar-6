package study.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.CarInput;

class CarInputTest {

    @Test
    void test_정상적인경우() {
        // given
        String input = "pobi,woni,jun";

        // when
        CarInput carInput = new CarInput(input);
        List<String> nameList = carInput.getNameList();

        // then
        assertThat(nameList).contains("pobi");
        assertThat(nameList).contains("woni");
        assertThat(nameList).contains("jun");
        assertThat(nameList.size()).isEqualTo(3);
    }

    @Test
    void test_빈_입력() {
        // given
        String input = "";

        // when

        // then
        assertThatThrownBy(() -> new CarInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어는 2명 이상이여야 합니다.");
    }

    @Test
    void test_한명인_경우() {
        // given
        String input = "pobi";

        // when

        // then
        assertThatThrownBy(() -> new CarInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어는 2명 이상이여야 합니다.");
    }

    @Test
    void test_길이가_0인_이름() {
        // given
        String input = "pobi,,woni";

        // when

        // then
        assertThatThrownBy(() -> new CarInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이는 0일 수 없고 5보다 길 수 없습니다.");
    }

    @Test
    void test_이름이_긴_경우() {
        // given
        String input = "pobi,woni,junjun";

        // when

        // then
        assertThatThrownBy(() -> new CarInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이는 0일 수 없고 5보다 길 수 없습니다.");
    }

    @Test
    void test_이름_중복() {
        // given
        String input = "pobi,woni,pobi";

        // when

        // then
        assertThatThrownBy(() -> new CarInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 있습니다.");
    }
}