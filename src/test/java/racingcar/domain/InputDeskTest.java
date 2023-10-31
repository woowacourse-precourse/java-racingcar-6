package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputDeskTest {

    private InputDesk inputdesk;

    @BeforeEach
    void setUp() {
        inputdesk = new InputDesk();
    }

    @Test
    void checkIllegalArgumentException_입력된_경주_자동차_이름_null() {
        String input = null;
        assertThatThrownBy(() -> inputdesk.checkIllegalArgumentException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 입력값 null");
    }

    @Test
    void checkIllegalArgumentException_파싱된_경주_자동차_이름_길이_0() {
        String input = "";
        assertThatThrownBy(() -> inputdesk.checkIllegalArgumentException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 길이 0");
    }

    @Test
    void checkIllegalArgumentException_파싱된_경주_자동차_이름_길이_5초과() {
        String input = "abcdef";
        assertThatThrownBy(() -> inputdesk.checkIllegalArgumentException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 길이 5 초과");
    }

    @Test
    void checkIllegalArgumentException_시도할_회수_입력_0이하() {
        int input = (int)(Math.random()*100*-1);
        assertThatThrownBy(() -> inputdesk.checkIllegalArgumentException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수 입력값 0 이하");
    }



}