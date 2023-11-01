package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NewApplicationTest extends NsTest{
    @Test
    void single_winner() {
        assertRandomNumberInRangeTest(
            () -> {
                run("Obi,Ani", "1");
                assertThat(output()).contains(
                    "Obi : -", "Ani : ", "최종 우승자 : Obi");
            }, 4, 3);
    }

    @Test
    void double_winner() {
        assertRandomNumberInRangeTest(
            () -> {
                run("Obi,Ani,Soka", "1");
                assertThat(output()).contains(
                    "Obi : ", "Ani : -", "Soka : -", "최종 우승자 : Ani, Soka");
            }, 3, 4);
    }

    @Test
    void empty_name() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(
                "", "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 입력하세요.")
        );
    }

    @Test
    void wrong_name() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(
                "Obi-Wan,Anakin,Ahsoka", "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 이름입니다.")
        );
    }

    @Test
    void not_a_number() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(
                "Obi,Ani", "Lightsaber"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력하세요.")
        );
    }

    @Test
    void wrong_number() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(
                "Yoda,Dooku", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수를 입력할 수 없습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }    
}
