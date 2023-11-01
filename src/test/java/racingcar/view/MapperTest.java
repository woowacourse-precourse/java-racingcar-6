package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MapperTest {

    @Test
    void String을_ListString으로_변환_1() {
        assertThat(Mapper.changeToListString("pobi1,pobi2,pobi3"))
                .isEqualTo(List.of("pobi1", "pobi2", "pobi3"));
    }

    @Test
    void String을_ListString으로_변환_2() {
        assertThat(Mapper.changeToListString(",,"))
                .isEqualTo(new ArrayList<>());
    }

    @Test
    void String을_ListString으로_변환_3() {
        assertThat(Mapper.changeToListString(""))
                .isEqualTo(List.of(""));
    }

    @Test
    void String을_ListString으로_변환_4() {
        assertThat(Mapper.changeToListString(" "))
                .isEqualTo(List.of(" "));
    }

    @Test
    void String을_int로_변환() {
        assertThat(Mapper.changeToInteger("1"))
                .isEqualTo(1);
    }

    @Test
    void String을_int로_변환_예외상황_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Mapper.changeToInteger("string"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자를 입력해야합니다.")
        );
    }

    @Test
    void String을_int로_변환_예외상황_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Mapper.changeToInteger("10000000000000000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("너무 큰 숫자를 입력했습니다.")
        );
    }

}
