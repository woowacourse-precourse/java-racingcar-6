package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class JudgmentTest{

    @Test
    void isOverFourDistance_입력받은_숫자가_4를_넘을경우() {

        assertThat(Judgment.isOverFourDistance(5)).isEqualTo(true);
    }

    @Test
    void isOverFourDistance_입력받은_숫자가_4보다_작을경우() {

        assertThat(Judgment.isOverFourDistance(3)).isEqualTo(false);
    }

    @Test
    void isOverFiveLength_이름의_길이가_5를_초과하는_경우() {
        String name = "abcdef";

        assertThatThrownBy(() -> {
            Judgment.isOverFiveLength(name);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessage("잘못된 길이의 이름이 입력됨 : " + name);

        /* Assertions.assertThrows(IllegalStateException.class, () -> {
            Judgment.isOverFiveLength(name);
        });
        */

    }

    void isOverFiveLength_이름의_길이가_1보다_작은_경우() {
        String name = "";

        assertThatThrownBy(() -> {
            Judgment.isOverFiveLength(name);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessage("잘못된 길이의 이름이 입력됨 : " + name);

    }

    @Test
    void isOverFiveLength_정상_작동_확인() {

        assertThat(Judgment.isOverFiveLength("pobi")).isEqualTo("pobi");

        assertThatCode(() -> Judgment.isOverFiveLength("pobi"))
                .doesNotThrowAnyException();
//         예외 발생이 없는 테스트를 작성할 떄는 assertThatCode 사용
//         assertThatThrownBy의 경우 예외가 발생하지 않을 경우 오류 발생

    }

    @Test
    void checkInteger_정상적으로_숫자_입력() {

        assertThat(Judgment.checkInteger("4")).isEqualTo(4);

        assertThatCode(() -> Judgment.isOverFiveLength("4"))
                .doesNotThrowAnyException();

    }
    @Test
    void checkInteger_숫자가아닌_다른_입력값() {

        String strValue = "abc";

        assertThatThrownBy(() -> {
            Judgment.checkInteger(strValue);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessage("잘못된 값 입력 : " + strValue);
    }

}