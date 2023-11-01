package racingcar.model;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;

class UserTest {

    @Test
    void 자동차_이름_입력() {
        InputStream in = new ByteArrayInputStream("pobi,woni,jun".getBytes());
        System.setIn(in);

        User user = new User();
        List<String> result = user.inputCarName();
        assertThat(result).isEqualTo(Arrays.asList("pobi", "woni", "jun"));
        Console.close();
    }

    @Test
    void 자동차_이름_입력_예외_처리_공백() {
        InputStream in = new ByteArrayInputStream("pobi,,jun".getBytes());
        System.setIn(in);

        User user = new User();
        assertThatThrownBy(() -> user.inputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1~5자여야 합니다.");

        Console.close();
    }

    @Test
    void 자동차_이름_입력_예외_처리_5자_초과() {
        InputStream in = new ByteArrayInputStream("pobilee,woni,jun".getBytes());
        System.setIn(in);

        User user = new User();
        assertThatThrownBy(() -> user.inputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1~5자여야 합니다.");

        Console.close();
    }

    @Test
    void 이동_횟수_입력() {
        InputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);

        User user = new User();
        int result = user.inputCount();
        assertThat(result).isEqualTo(3);
        Console.close();
    }

    @Test
    void 이동_횟수_입력_예외_처리_숫자가_아닌_경우() {
        InputStream in = new ByteArrayInputStream("3번".getBytes());
        System.setIn(in);

        User user = new User();
        assertThatThrownBy(() -> user.inputCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 숫자여야 합니다.");

        Console.close();
    }

    @Test
    void 이동_횟수_입력_예외_처리_공백() {
        InputStream in = new ByteArrayInputStream(" ".getBytes());
        System.setIn(in);

        User user = new User();
        assertThatThrownBy(() -> user.inputCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 숫자여야 합니다.");

        Console.close();
    }


}