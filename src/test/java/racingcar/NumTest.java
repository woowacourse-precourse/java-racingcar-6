package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import game.NumOfAttempt;
import game.car.CarName;
import org.junit.jupiter.api.Test;

public class NumTest {
    @Test
    void NumOfAttempt_가운데_공백이_있는_숫자_입력시_예외_발생() {
        assertThatThrownBy(() -> new NumOfAttempt("2 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("회수는 숫자만 입력해야합니다.");
    }

    @Test
    void NumOfAttempt_앞뒤_공백이_있는_숫자_입력시_예외_발생() {
        assertThatThrownBy(() -> new NumOfAttempt(" 23  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("회수는 숫자만 입력해야합니다.");
    }

    @Test
    void NumOfAttempt_공백_입력시_예외_발생() {
        assertThatThrownBy(() -> new NumOfAttempt(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("회수는 숫자만 입력해야합니다.");
    }
    @Test
    void NumOfAttempt_숫자가_아닌_값_입력시_예외_발생() {
        assertThatThrownBy(() -> new NumOfAttempt("56d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("회수는 숫자만 입력해야합니다.");
    }

    @Test
    void NumOfAttempt_음수_입력시_예외_발생() {
        assertThatThrownBy(() -> new NumOfAttempt("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("회수는 양수여야 합니다.");
    }

    @Test
    void NumOfAttempt_0_입력시_예외_발생() {
        assertThatThrownBy(() -> new NumOfAttempt("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("회수는 양수여야 합니다.");
    }
}
