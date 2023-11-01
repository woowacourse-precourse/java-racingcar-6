package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.common.ExceptionMessage;

class NameSeparatorTest {

    @Test
    void 이름_입력_정상() {
        assertDoesNotThrow(() -> {
            NameSeparator.separateNamesByComma("pobi,woni,jun");
        });

        List<String> names = NameSeparator.separateNamesByComma("pobi,woni,jun");
        assertThat(names.containsAll(List.of("pobi", "woni", "jun"))).isEqualTo(true);
        assertThat(names.size()).isEqualTo(3);
    }

    @Test
    void 이름_입력_5글자_초과() {
        String inputCarNames = "pobi,woni,jun,abcdefg";
        assertThatThrownBy(() -> NameSeparator.separateNamesByComma(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.MORE_THAN_ALLOWED_NAME_LENGTH.getMessage());
    }

    @Test
    void 이름_입력_빈값() {
        String inputCarNames = "pobi,woni,,jun";
        assertThatThrownBy(() -> NameSeparator.separateNamesByComma(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.EMPTY_NAME.getMessage());
    }

    @Test
    void 이름_입력_쉼표로_끝남() {
        String inputCarNames = "pobi,woni,jun,";
        assertThatThrownBy(() -> NameSeparator.separateNamesByComma(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.ENDS_WITH_COMMA.getMessage());
    }

}