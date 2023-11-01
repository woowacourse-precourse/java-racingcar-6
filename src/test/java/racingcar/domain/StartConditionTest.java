package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StartConditionTest {

/*    @Test
    void split_입력받은_자동차이름_구분() {
        StartCondition startCondition = new StartCondition();

        String[] result = startCondition.inputCarName();

        assertThat(result).contains("po", "ta", "to");
        assertThat(result).containsExactly("po", "ta", "to");*/
    }

    @Test
    void 다섯자_넘는_이름_종료() {
        String carName = "po,ta,to,potato";

        assertThatThrownBy(() -> new StartCondition().checkInputCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputAttemptNumber() {
    }
}