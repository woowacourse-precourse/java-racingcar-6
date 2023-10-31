package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputDeskTest {

    private InputDesk inputdesk;

    @BeforeEach
    void setUp() {
        inputdesk = new InputDesk();
    }

    @Test
    void checkIsNull_입력된_값_null() {
        String input = null;
        assertThatThrownBy(() -> inputdesk.checkIsNull(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사용자 입력값 null");
    }

    @ParameterizedTest
    @CsvSource({"\0,자동차 이름 길이 0", "abcdef,자동차 이름 길이 5 초과"})
    void checkIllegalArgumentException_파싱된_경주_자동차_이름_길이(String input, String expected) {
        assertThatThrownBy(() -> inputdesk.checkIllegalArgumentException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }


    @Test
    void checkIllegalArgumentException_시도할_회수_입력_0이하() {
        int input = (int) (Math.random() * 100 * -1);
        assertThatThrownBy(() -> inputdesk.checkIllegalArgumentException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수 입력값 0 이하");
    }


}