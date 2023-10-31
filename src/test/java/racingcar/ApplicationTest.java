package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 9;

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
    void 주사위는_최솟값과_최댓값사이의_수를_반환한다(){
        final Dice dice = new Dice();
        int randomNum = dice.roll();
        assertThat(randomNum >= MINIMUM && randomNum <= MAXIMUM).isTrue();
    }

    @Test
    void 자동차_이름은_숫자를_포함하지_않는다() {
        final Game game = new Game();
        assertThatThrownBy(() -> runException("1234")).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 자동차이름_입력시_공백을_제거한다(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("  pobi    ,          woni     ", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 게임_진행횟수는_숫자이다() {
        final Game game = new Game();
        assertThatThrownBy(() -> runException("test", "seven")).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 게임_진행횟수는_1이상이어야_한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("test, player", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 아무도_전진하지_못한경우_우승자는_존재하지_않는다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("이런, 아무도 움직이지 못했군요! 우승자가 없습니다.");
                },
                STOP, STOP
        );
    }

}
