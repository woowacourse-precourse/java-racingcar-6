package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("자동차의 이름이 6글자를 초과한 경우 예외처리")
    public void nameLengthCheck() {
        //given
        String name = "여섯글자이름";
        //when

        //then
        assertThatThrownBy(() -> {
            nameLength(name.length());
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 다섯글자까지만 허용합니다.");
    }

    @Test
    @DisplayName("이름이 공백일경우 예외처리")
    public void nameBlankCheck() {
        //given
        String blankName = " ";
        //when

        //then
        assertThatThrownBy(() -> new Car(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백의 이름은 허용하지 않습니다.");

    }

    private void nameLength(int length) {
        if (length > 5) {
            throw new IllegalArgumentException("자동차의 이름은 다섯글자까지만 허용합니다.");
        }
    }
}
