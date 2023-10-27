package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class myTest extends NsTest {
    @Test
    void 자동차_이름_중복_예외_테스트() {
        assertThatThrownBy(() -> {
            run("succ,ess,ful,ess");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 있습니다.");
    }

    @Test
    void 자동차_이름_공백_예외_테스트() {
        assertThatThrownBy(() -> {
            run("1,,more_than_five");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1자 이상");
    }

    @Test
    void 자동차_이름_길이_예외_테스트() {
        assertThatThrownBy(() -> {
            run("1,2,more_than_five");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1자 이상");
    }

    @Test
    void 라운드_수_글자_입력_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> {
                        run("john,pobi,tree,hash", "안녕");
                    }).isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("양수를 입력하지 않았습니다.");
                },
                1
        );
    }

    @Test
    void 단일_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("john,tree,hash", "3");
                    assertThat(output()).contains("tree");
                },
                0, 5, 0, 0, 5, 0, 0, 5, 0
        );
    }

    @Test
    void 다중_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("john,tree,hash", "3");
                    assertThat(output()).contains("tree, hash");
                },
                0, 5, 6, 0, 5, 6, 0, 5, 6
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
