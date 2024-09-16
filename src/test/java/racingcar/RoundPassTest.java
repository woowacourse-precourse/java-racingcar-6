package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RoundPassTest extends NsTest {
    @Test
    void 진행_횟수_입력_검증1() {
        run("woowa,hello,beast", "20");
        assertThat(output()).contains("woowa : ", "hello : ", "beast : ", "최종 우승자 : ");
    }

    @Test
    void 진행_횟수_입력_검증2() {
        run("tony,hello,stark", "19");
        assertThat(output()).contains("tony : ", "hello : ", "stark : ", "최종 우승자 : ");
    }

    @Test
    void 진행_횟수_입력_검증3() {
        run("a,b,c", "1");
        assertThat(output()).contains("a : ", "b : ", "c : ", "최종 우승자 : ");
    }

    @Test
    void 진행_횟수_입력_검증4() {
        run("woowa,hello,beast", "10");
        assertThat(output()).contains("woowa : ", "hello : ", "beast : ", "최종 우승자 : ");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
