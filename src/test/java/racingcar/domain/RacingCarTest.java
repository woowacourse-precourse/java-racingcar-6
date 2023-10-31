package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


class RacingCarTest {

    RacingCar racingCar = new RacingCar();

    @Test
    void exception_null_입력() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> racingCar.setCarName(null));
    }

    @Test
    void exception_입력값_없음() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> racingCar.setCarName(""));

    }

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        List<String> actual = racingCar.setCarName(input);

        assertThat(actual).contains("1", "2");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void exception_이름_하나만_입력1() {
        String input = "안녕,";
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> racingCar.setCarName(input));

    }
    @Test
    void exception_이름_하나만_입력2() {
        String input = "안녕";
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> racingCar.setCarName(input));

    }

    @Test
    void exception_6자_이상의_이름_입력() {
        String input = "pobi,javaji";
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> racingCar.setCarName(input));
    }
}