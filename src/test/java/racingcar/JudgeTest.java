package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class JudgeTest {
    private Judge judge = new Judge(5, 4, 0, 9);;

    @Test
    void 움직일_수_없을_때_canMove() {
        // canMove의 파라미터는 pickRandomNumber()를 이용하므로, 범위 내의 값이 무조건 나오게 된다.
        boolean move = judge.canMove(0);

        assertThat(move).isEqualTo(false);
    }

    @Test
    void 입력값이_범위의_경계선에_있을_때_canMove() {
        // canMove의 파라미터는 pickRandomNumber()를 이용하므로, 범위 내의 값이 무조건 나오게 된다.
        boolean move = judge.canMove(4);

        assertThat(move).isEqualTo(true);
    }

    @Test
    void 움직일_수_있을_때_canMove() {
        // canMove의 파라미터는 pickRandomNumber()를 이용하므로, 범위 내의 값이 무조건 나오게 된다.
        boolean move = judge.canMove(9);

        assertThat(move).isEqualTo(true);
    }

    @Test
    void 차가_한_대일_때_isEffectiveInputNames() {
        Optional<String> name = Optional.ofNullable("a");
        boolean effectiveInputNames = judge.isEffectiveInputNames(name);

        assertThat(effectiveInputNames).isEqualTo(true);
    }

    @Test
    void 차가_두_대일_때_isEffectiveInputNames() {
        Optional<String> name = Optional.ofNullable("a,b");
        boolean effectiveInputNames = judge.isEffectiveInputNames(name);

        assertThat(effectiveInputNames).isEqualTo(true);
    }

    @Test
    void 차가_두_대일_때_하나라도_이름이_5글자가_넘을_때_isEffectiveInputNames() {
        Optional<String> name = Optional.ofNullable("a,fiveString");

        assertThatThrownBy(() -> judge.isEffectiveInputNames(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하입니다.");
    }

    @Test
    void 아무_것도_입력하지_않았을_때_isEffectiveInputNames() {
        Optional<String> name = Optional.ofNullable("");

        assertThatThrownBy(() -> judge.isEffectiveInputNames(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하입니다.");
    }

    @Test
    void 차가_한_대일_때_이름이_5글자가_넘을_때_isEffectiveInputNames() {
        Optional<String> name = Optional.ofNullable("fivenumber");

        assertThatThrownBy(() -> judge.isEffectiveInputNames(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하입니다.");
    }

    @Test
    void 입력값이_없을_때_isEffectiveInputTurn() {
        Optional<String> turn = Optional.ofNullable("");

        assertThatThrownBy(() -> judge.isEffectiveInputTurn(turn))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 양의 정수여야합니다.");
    }

    @Test
    void 입력값이_정상적일_때_isEffectiveInputTurn() {
        Optional<String> turn = Optional.ofNullable("2");

        judge.isEffectiveInputTurn(turn);
    }

    @Test
    void 입력값이_음수일_때_isEffectiveInputTurn() {
        Optional<String> turn = Optional.ofNullable("-1");

        assertThatThrownBy(() -> judge.isEffectiveInputTurn(turn))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 양의 정수여야합니다.");
    }

    @Test
    void 입력값이_0일_때_isEffectiveInputTurn() {
        Optional<String> turn = Optional.ofNullable("0");

        assertThatThrownBy(() -> judge.isEffectiveInputTurn(turn))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 양의 정수여야합니다.");
    }

    @Test
    void 입력값이_숫자가_아닐_때_isEffectiveInputTurn() {
        Optional<String> turn = Optional.ofNullable("shin");

        assertThatThrownBy(() -> judge.isEffectiveInputTurn(turn))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 양의 정수여야합니다.");
    }
}